package es.iesptocruz.victor.modelo;

import java.sql.SQLException;

import es.iesptocruz.victor.api.Ruta;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public class RutaModelo{

   DdBbSqLite persistencia;
   private static final String TABLA  = "RUTA";
   private static final String CLAVE  = "IDENTIFICADOR";
   
   public RutaModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
   }

   public void insertar(Ruta ruta) throws PersistenciaException {
      String sql="insert into "+TABLA+"(identificador, nombre, fecha, turistas, telefono, distancia)"
      +" values ('"+ruta.getIdentificador()
      +"','"+ruta.getNombre()+"',"+ruta.getFecha()+","+ruta.getTuristas()
      +","+ruta.getTelefono()+","+ruta.getDistancia()+")";
      persistencia.update(sql);
   }

   public void eliminar(Ruta ruta) throws PersistenciaException {
      String sql = "DELETE FROM "+TABLA+" WHERE "+CLAVE+" = '" + ruta.getIdentificador() + "'";
      persistencia.update(sql);
   }

   public Ruta buscar(String codigo) throws PersistenciaException {
      return (Ruta) persistencia.buscarElemento(codigo);
   }

   public void actualizar(Ruta ruta) throws PersistenciaException {
      String sql="update "+TABLA+" set identificador = "+ruta.getIdentificador()
      +" where identificador like '%"+ruta.getIdentificador()+"%'";
      persistencia.update(sql);
   }

   /**
    * Metodo que muestra todos los campos de la bbdd
    * @throws PersistenciaException
    * @throws SQLException
    */
   public String mostrar() throws PersistenciaException, SQLException {
      String sql = "SELECT * FROM " + TABLA ;
      return persistencia.mostrar(sql);
   }
   
}
