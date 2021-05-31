package es.iesptocruz.victor.modelo;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class DdBbSqLite extends DdBb {
   private static final String DRIVER = "org.sqlite.JDBC";
   private static final String URL = "jdbc:sqlite:turistas.db";

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
}
