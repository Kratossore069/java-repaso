package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class DdBbSqLite extends DdBb {
   private static final String DRIVER = "org.sqlite.JDBC";
   private static final String URL = "jdbc:sqlite:usuario.db";
   Connection connection=null;
   PreparedStatement ps=null;

   /**
    * Constructor de cualquier bbdd
    * @param nombreTabla
    * @param clave
    * @param driver
    * @param urlConexion
    * @param usuario
    * @param password
    * @throws PersistenciaException
    */
   public DdBbSqLite(String nombreTabla, String clave, String driver, String urlConexion, String usuario,
         String password) throws PersistenciaException {
      super(nombreTabla, clave, driver, urlConexion, usuario, password);
   }

   /**
    * Constructor de sqlite
    * @param nombreTabla
    * @param clave
    * @param usuario
    * @param password
    * @throws PersistenciaException
    */
   public DdBbSqLite(String nombreTabla, String clave, String usuario, String password) throws PersistenciaException {
      super(nombreTabla, clave, DRIVER, URL, usuario, password);
   }

   /**
    * Metodo de prueba para conectar una bbdd
    * @throws PersistenciaException error
    * @throws SQLException controlado
    * @throws ClassNotFoundException controlado
    */
   public void connectSqlite() throws PersistenciaException, SQLException, ClassNotFoundException{
      try{
         Class.forName(DRIVER);
         connection=DriverManager.getConnection(URL);
      }catch(SQLException | ClassNotFoundException ex){
         throw new PersistenciaException("Error al crear ", ex);
      }
   }
}
