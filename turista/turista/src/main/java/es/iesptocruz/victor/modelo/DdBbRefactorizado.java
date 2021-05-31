package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesptocruz.victor.api.Ruta;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public abstract class DdBbRefactorizado {

   private static final String TABLE = "TABLE";
   private static final String TABLE_NAME = "TABLE_NAME";

   protected String nombreTabla;
   protected String clave;
   protected String driver;
   protected String urlConexion;
   protected String usuario;
   protected String password;

   /**
    * Constructor por defecto
    * 
    * @param nombreTabla
    * @param clave       tabla
    * @param driver      de la bbdd
    * @param urlConexion de la bbdd
    * @param usuario     de la bbdd
    * @param password    de la bbdd
    * @throws PersistenciaException controlado
    */
   public DdBbRefactorizado(String nombreTabla, String clave, String driver, String urlConexion, String usuario,
         String password) throws PersistenciaException {
      this.nombreTabla = nombreTabla;
      this.clave = clave;
      this.driver = driver;
      this.urlConexion = urlConexion;
      this.usuario = usuario;
      this.password = password;
      inicializarTabla(nombreTabla);
   }

   private void inicializarTabla(String tabla) throws PersistenciaException {
      DatabaseMetaData databaseMetaData;
      Connection connection = null;
      ResultSet resultSet = null;
      ArrayList<String> listaTablas = new ArrayList<>();
      try {
         connection = getConnection();
         databaseMetaData = connection.getMetaData();
         resultSet = databaseMetaData.getTables(null, null, null, new String[] { TABLE });
         while (resultSet.next()) {
            listaTablas.add(resultSet.getString("TABLE_NAME"));
         }
         if (!listaTablas.contains(tabla)) {
            String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS Ruta (" 
                  + " identificador VARCHAR(50) PRIMARY KEY,"
                  + "nombre VARCHAR(50) NOT NULL," + "fecha DATE," 
                  + "turistas int NOT NULL,"
                  +" telefono int NOT NULL, "
                  +" distancia int);";
            update(sqlCrearTabla);
         }

      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
      } finally {
         closeConecction(connection, null, resultSet);
      }

   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * 
    * @return conexion abierta
    * @throws PersistenciaException controlado
    */
   public Connection getConnection() throws PersistenciaException {
      Connection connection = null;

      try {
         Class.forName(driver);
         if (usuario != null && password != null) {
            connection = DriverManager.getConnection(urlConexion, usuario, password);
         } else {
            connection = DriverManager.getConnection(urlConexion);
         }
      } catch (ClassNotFoundException | SQLException exception) {
         throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
      }

      return connection;
   }

   /**
    * Funcion encargada de obtener un Ruta
    * 
    * @param identificador del Ruta
    * @return Objeto Ruta
    * @throws PersistenciaException controlado
    */
   public Object buscarElemento(String identificador) throws PersistenciaException {
      Object elemento = null;
      String sql = "SELECT * FROM " + this.nombreTabla + " WHERE " + this.clave + "='" + identificador + "'";
      ArrayList<Object> lista = buscar(sql);
      if (!lista.isEmpty()) {
         elemento = lista.get(0);
      }
      return elemento;
   }

   /**
    * Funcion que obtiene todos los usuarios de la BBDD
    * 
    * @return lista usuarios
    * @throws PersistenciaException error controlado
    */
   public ArrayList<Object> buscarTodos() throws PersistenciaException {
      String sql = "SELECT * FROM " + this.nombreTabla;
      return buscar(sql);
   }

   /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * 
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Object> buscar(String sql) throws PersistenciaException {
      ArrayList<Object> lista = new ArrayList<>();
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery();

         while (resultSet.next()) {
            Ruta ruta = new Ruta();
            ruta.setDistancia(resultSet.getInt("distancia"));
            ruta.setFecha(resultSet.getDate("fecha"));
            ruta.setIdentificador(resultSet.getString("identificador"));
            ruta.setNombre(resultSet.getString("nombre"));
            ruta.setTelefono(resultSet.getInt("telefono"));
            ruta.setTuristas(resultSet.getInt("turistas"));
            lista.add(ruta);
         }
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return lista;
   }

   /**
    * Metodo encargado de realizar las inserciones/modificaciones/eliminacion de la
    * BBDD
    * 
    * @param sql con la sentencia
    * @throws PersistenciaException error controlado
    */
   public void update(String sql) throws PersistenciaException {
      PreparedStatement statement = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         statement.executeUpdate();
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la modificacion/insercion", exception);
      } finally {
         closeConecction(connection, statement, null);
      }
   }

   /**
    * Metodo encargado de realizar el cierre de la conexion con la BBDD
    * 
    * @param connection contra la BBDD
    * @param statement  de la operacion
    * @param resultSet  resultado
    * @throws PersistenciaException error controlado
    */
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet)
         throws PersistenciaException {
      try {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (connection != null) {
            connection.close();
         }
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error cerrando la sesion con la BBDD");
      }

   }

   
   // public String mostrar(String sql) throws PersistenciaException, SQLException {
   //    PreparedStatement statement = null;
   //    ResultSet resultSet = null;
   //    Connection connection = null;
   //    String resultado = null;
   //    try {
   //       connection = getConnection();
   //       statement = connection.prepareStatement(sql);
   //       resultSet = statement.executeQuery();

   //       if (resultSet.next()) {
   //          while (resultSet.next()) {
   //             resultado = resultSet.getString("codigo");
   //             resultado += resultSet.getString("cliente");
   //             resultado += resultSet.getInt("email");
   //             resultado += resultSet.getInt("saldo");
   //          }
   //       }
   //    } catch (PersistenciaException ex) {
   //       throw new PersistenciaException("Error al ejecutar " + ex.getMessage());
   //    } finally {
   //       statement.close();
   //    }
   //    return resultado;
   // }

}
