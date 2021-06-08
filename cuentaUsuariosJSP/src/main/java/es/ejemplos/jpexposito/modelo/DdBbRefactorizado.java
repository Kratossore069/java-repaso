package es.ejemplos.jpexposito.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public abstract class DdBbRefactorizado {

   private static final String TABLE = "TABLE";
   private static final String TABLE_NAME = "TABLE_NAME";

   protected String nombreTabla;
   protected String clave;
   protected String driver;
   protected String urlConexion;
   protected String usuario;
   protected String password;

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
            String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS usuario (" 
            + "dni VARCHAR(9) PRIMARY KEY,"
            + "nombre varchar(50));";
            update(sqlCrearTabla);
         }

      } catch (Exception e) {
         throw new PersistenciaException(e.getMessage());
      } finally {
         closeConecction(connection, null, resultSet);
      }

   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * 
    * @return conexion abierta
    * @throws PersistenciaException
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
         throw new PersistenciaException(exception.getMessage());
      }

      return connection;
   }

   /**
    * Funcion encargada de obtener un cuenta
    * 
    * @param identificador del cuenta
    * @return Objeto cuenta
    * @throws PersistenciaException
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
            Usuario usuarioApi=new Usuario();
            usuarioApi.setNombre(resultSet.getString("nombre"));
            usuarioApi.setDni(resultSet.getString("dni"));
            lista.add(usuarioApi);
         }
      } catch (SQLException exception) {
         throw new PersistenciaException(exception.getMessage());
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
         throw new PersistenciaException(exception.getMessage());
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
         throw new PersistenciaException(e.getMessage());
      }

   }

   /**
    * Funcion que hace un select de todos los campos
    * 
    * @param sql sentencia a buscar
    * @return retorna un String con los datos de la bbdd
    * @throws PersistenciaException controlado
    * @throws SQLException          controlado
    */
   public String mostrar(String sql) throws PersistenciaException, SQLException {
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      String resultado = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery();

         if (resultSet.next()) {
            while (resultSet.next()) {
               resultado = resultSet.getString("nombre");
               resultado += resultSet.getString("dni");
            }
         }
      } catch (PersistenciaException ex) {
         throw new PersistenciaException(ex.getMessage());
      } finally {
         statement.close();
      }
      return resultado;
   }

}
