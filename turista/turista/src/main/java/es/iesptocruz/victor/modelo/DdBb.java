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



public abstract class DdBb {

   private static final String TABLE = "TABLE";
   private static final String TABLE_NAME= "RUTA";

   protected String driver;
   protected String urlConexion;
   protected String usuario;
   protected String password;

   public DdBb(String driver, String urlConexion, String usuario, String password) throws PersistenciaException {
      this.driver = driver;
      this.urlConexion = urlConexion;
      this.usuario = usuario;
      this.password = password;
      inicializarDdBd();
   }

   private void inicializarDdBd() throws PersistenciaException {
      DatabaseMetaData databaseMetaData;
      Connection connection = null;
      ResultSet resultSet = null;
      ArrayList<String> listaTablas = new ArrayList<>();
      try {
         connection = getConnection();
         databaseMetaData = connection.getMetaData();
         resultSet = databaseMetaData.getTables(null, null, null, new String[] {TABLE});
         while (resultSet.next()) {
            listaTablas.add(resultSet.getString("TABLE_NAME"));
        }
        if (!listaTablas.contains(TABLE_NAME)) {
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
         throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
      }
      
      return connection;
   }

   /**
    * Funcion encargada de obtener un Ruta
    * 
    * @param identificador del Ruta
    * @return Objeto Ruta
    * @throws PersistenciaException
    */
   public Ruta buscarRuta(String identificador) throws PersistenciaException {
      Ruta ruta = null;
      String sql = "SELECT * FROM "+TABLE_NAME+" WHERE identificador='"+identificador+"'";
      ArrayList<Ruta> lista = buscar(sql);
      if (!lista.isEmpty()) {
         ruta = lista.get(0);
      }
      return ruta;
   }

   /**
    * Funcion que obtiene todos los usuarios de la BBDD
    * @return lista usuarios
    * @throws PersistenciaException error controlado
    */
    public ArrayList<Ruta> buscarTodos() throws PersistenciaException {
      String sql = "SELECT * FROM " + TABLE_NAME;
      return buscar(sql);
   }
   /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Ruta> buscar(String sql) throws PersistenciaException {
      ArrayList<Ruta> lista = new ArrayList<>();
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery();

         while(resultSet.next()) {
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
    * Metodo encargado de realizar la insercion en la BBDD
    * 
    * @param usuario a insertar
    * @throws PersistenciaException
    */
   public void insertar(Ruta ruta) throws PersistenciaException {
      String sql="insert into "+TABLE+"(identificador, nombre, fecha, turistas, telefono, distancia)"
      +" values ('"+ruta.getIdentificador()
      +"','"+ruta.getNombre()+"',"+ruta.getFecha()+","+ruta.getTuristas()
      +","+ruta.getTelefono()+","+ruta.getDistancia()+")";
      update(sql);
   }

   /**
    * Metodo encargado de realizar la actualizacion de un Ruta
    * @param Ruta a actualizar
    * @throws PersistenciaException error controlado
    */
   public void update(Ruta ruta) throws PersistenciaException {
      String sql="update "+TABLE+" set identificador = "+ruta.getIdentificador()
      +" where identificador like '%"+ruta.getIdentificador()+"%'";
      update(sql);
   }
   /**
    * Metodo encargado de realizar la actualizacion en la BBDD
    * 
    * @param Ruta a actualizar
    * @throws PersistenciaException
    */
   public void eliminar(String identificador) throws PersistenciaException {
      String sql = "DELETE FROM Ruta WHERE identificador = '" + identificador + "'";
      update(sql);
   }

   /**
    * Metodo encargado de realizar las inserciones/modificaciones/eliminacion de la BBDD
    * @param sql con la sentencia
    * @throws PersistenciaException error controlado
    */
   public void update(String sql) throws PersistenciaException {
      PreparedStatement statement = null;
      Connection connection = null;
      try {
         connection= getConnection();
         statement = connection.prepareStatement(sql);
         statement.executeUpdate();
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
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
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
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


}
