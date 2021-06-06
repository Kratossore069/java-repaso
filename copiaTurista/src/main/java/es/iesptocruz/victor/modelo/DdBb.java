package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public abstract class DdBb {

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
   public DdBb(String nombreTabla, String clave, String driver, String urlConexion, String usuario,
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
            String sqlCrearTabla="create table if not exists Persona("
            +"dni varchar(9),"
            +"nombre varchar(50));";
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
    * @param identificador del usuario
    * @return Objeto usuario
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

   public Date stringToDate(String strDate) throws PersistenciaException {
      Date date = null;
      SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
      try{
         date = formatter.parse(strDate);
      }catch(Exception ex){
         ex.getMessage();
      }
      return date;
  }

   /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * 
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Object> buscar(String sql) throws PersistenciaException{
      ArrayList<Object> lista = new ArrayList<>();
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.prepareStatement(sql);
         resultSet = statement.executeQuery();

         while (resultSet.next()) {
            Usuario usuarioApi = new Usuario();
            usuarioApi.setDni(resultSet.getString("dni"));
            usuarioApi.setNombre(resultSet.getString("nombre"));
            lista.add(usuarioApi);
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
}
