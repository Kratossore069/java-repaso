package es.iesptocruz.victor.modelo;

import java.sql.SQLException;

import es.iesptocruz.victor.api.Ruta;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public class RutaModelo {

   DdBbSqLite persistencia;
   private static final String TABLA = "RUTA";
   private static final String CLAVE = "IDENTIFICADOR";

   /**
    * Constructor por defecto
    * 
    * @throws PersistenciaException controlado
    */
   public RutaModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
   }

   /**
    * Inserta en la tabal nueva informacion
    * 
    * @param ruta a insertar
    * @throws PersistenciaException controlado
    */
   public void insertar(Ruta ruta) throws PersistenciaException {
      String sql = "insert into " + TABLA + "(identificador, nombre, fecha, turistas, telefono, distancia)"
            + " values ('" + ruta.getIdentificador() + "','" + ruta.getNombre() + "','" + ruta.getFecha() + "',"
            + ruta.getTuristas() + "," + ruta.getTelefono() + "," + ruta.getDistancia() + ")";
      persistencia.update(sql);
   }

   /**
    * Elimina una columna a partir de un identificador aniadido
    * 
    * @param ruta a buscar y eliminar
    * @throws PersistenciaException controlado
    */
   public void eliminar(Ruta ruta) throws PersistenciaException {
      String sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = '" + ruta.getIdentificador() + "'";
      persistencia.update(sql);
   }

   /**
    * Metodo que busca un elemento entero a partir de un codigo
    * 
    * @param codigo a buscar en la bbdd
    * @return el elemento encontrado
    * @throws PersistenciaException controlado
    */
   public Ruta buscar(String codigo) throws PersistenciaException {
      return (Ruta) persistencia.buscarElemento(codigo);
   }

   /**
    * Metodo que actualiza una tabla en la bbdd
    * 
    * @param ruta informacion sobre la ruta turistica
    * @throws PersistenciaException controlado
    */
   public void actualizar(Ruta ruta) throws PersistenciaException {
      String sql = "update " + TABLA + " set identificador = " + ruta.getIdentificador()
            + " where identificador like '%" + ruta.getIdentificador() + "%'";
      persistencia.update(sql);
   }

   // public String mostrar() throws PersistenciaException, SQLException {
   // String sql = "SELECT * FROM " + TABLA ;
   // return persistencia.mostrar(sql);
   // }

}
