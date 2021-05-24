package es.ejemplos.jpexposito.controlador;

import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.exception.PersistenciaException;
import es.ejemplos.jpexposito.modelo.CuentaModelo;

public class CuentaControlador {

   CuentaModelo cuentaModelo;

   public CuentaControlador() throws PersistenciaException {
      cuentaModelo = new CuentaModelo();
   }

   /**
    * Metodo para aniadir una cuenta
    * @param cuenta a aniadir
    * @throws PersistenciaException controlado
    */
   public void aniadirCuenta(Cuenta cuenta) throws PersistenciaException{
      validarCampos(cuenta);
      cuentaModelo.insertar(cuenta);
   }

   /**
    * Metodo para eliminar una cuenta
    * @param cuenta a eliminar
    * @throws PersistenciaException controlado
    */
   public void eliminarCuenta(Cuenta cuenta) throws PersistenciaException{
      validarCampos(cuenta);
      cuentaModelo.eliminar(cuenta);
   }

   /**
    * Funcion que busca una cuenta como parametro
    * @param cuenta a buscar
    * @return la cuenta
    * @throws PersistenciaException controlado
    */
   public Cuenta buscarCuenta(Cuenta cuenta) throws PersistenciaException{
      validarCampos(cuenta);
      return cuentaModelo.buscar(cuenta.getCodigo());
   }

   /**
    * Metodo que actualiza una cuenta
    * @param cuenta a actualizar
    * @throws PersistenciaException controlado
    */
   public void actualizaCuenta(Cuenta cuenta) throws PersistenciaException{
      validarCampos(cuenta);
      cuentaModelo.actualizar(cuenta);
   }

   /**
    * Metodo para evaluar la entrada de datos
    * @param cuenta a evaluar
    * @throws PersistenciaException controlado
    */
   public void validarCampos(Cuenta cuenta) throws PersistenciaException{
      if(cuenta==null || cuentaModelo.buscar(cuenta.getCodigo())==null)
         throw new PersistenciaException("Error");
   }
   
}
