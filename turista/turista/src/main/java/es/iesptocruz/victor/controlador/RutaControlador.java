package es.iesptocruz.victor.controlador;

import java.sql.SQLException;

import es.iesptocruz.victor.api.Ruta;
import es.iesptocruz.victor.excepciones.PersistenciaException;
import es.iesptocruz.victor.modelo.RutaModelo;



public class RutaControlador {

   RutaModelo rutaModelo;

   public RutaControlador() throws PersistenciaException {
      rutaModelo = new RutaModelo();
   }

   /**
    * Metodo para aniadir una Ruta
    * @param ruta a aniadir
    * @throws PersistenciaException controlado
    */
   public void aniadirRuta(Ruta ruta) throws PersistenciaException{
      validarCampos(ruta);
      rutaModelo.insertar(ruta);
   }

   /**
    * Metodo para eliminar una Ruta
    * @param Ruta a eliminar
    * @throws PersistenciaException controlado
    */
   public void eliminarRuta(Ruta ruta) throws PersistenciaException{
      validarCampos(ruta);
      rutaModelo.eliminar(ruta);
   }

   
   // public void mostrarTodo() throws PersistenciaException, SQLException{
   //    rutaModelo.mostrar();
   // }

   /**
    * Funcion que busca una Ruta como parametro
    * @param Ruta a buscar
    * @return la Ruta
    * @throws PersistenciaException controlado
    */
   public Ruta buscarRuta(Ruta ruta) throws PersistenciaException{
      validarCampos(ruta);
      return rutaModelo.buscar(ruta.getIdentificador());
   }

   /**
    * Metodo que actualiza una Ruta
    * @param Ruta a actualizar
    * @throws PersistenciaException controlado
    */
   public void actualizaRuta(Ruta ruta) throws PersistenciaException{
      validarCampos(ruta);
      rutaModelo.actualizar(ruta);
   }

   /**
    * Metodo para evaluar la entrada de datos
    * @param Ruta a evaluar
    * @throws PersistenciaException controlado
    */
   public void validarCampos(Ruta ruta) throws PersistenciaException{
      if(ruta==null || rutaModelo.buscar(ruta.getIdentificador())==null)
         throw new PersistenciaException("Error");
   }
   
}
