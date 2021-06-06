package es.iesptocruz.victor.controlador;

import java.sql.SQLException;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.excepciones.PersistenciaException;
import es.iesptocruz.victor.modelo.UsuarioModelo;

public class UsuarioControlador {

   UsuarioModelo usuarioModelo;

   public UsuarioControlador() throws PersistenciaException {
      usuarioModelo = new UsuarioModelo();
   }

   /**
    * Metodo para aniadir una Ruta
    * 
    * @param usuario a aniadir
    * @throws PersistenciaException controlado
    */
   public void aniadirUsuario(Usuario usuario) throws PersistenciaException {
      validarCampos(usuario);
      usuarioModelo.insertar(usuario);
   }

   /**
    * Metodo para eliminar una Ruta
    * 
    * @param Ruta a eliminar
    * @throws PersistenciaException controlado
    */
   public void eliminarUsuario(Usuario usuario) throws PersistenciaException {
      validarCampos(usuario);
      usuarioModelo.eliminar(usuario);
   }

   /**
    * Funcion que busca una Ruta como parametro
    * 
    * @param usuario a buscar
    * @return el usuario
    * @throws PersistenciaException controlado
    */
   public Usuario buscarUsuario(Usuario usuario) throws PersistenciaException {
      validarCampos(usuario);
      return usuarioModelo.buscar(usuario.getDni());
   }

   /**
    * Metodo que actualiza un usuario
    * 
    * @param usuario a actualizar
    * @throws PersistenciaException controlado
    */
   public void actualizar(Usuario usuario) throws PersistenciaException {
      validarCampos(usuario);
      usuarioModelo.actualizar(usuario);
   }

   /**
    * Funcion que valida un dni insertado
    * @param dni a validar
    * @return true or false
    * @throws PersistenciaException controlado
    */
   public boolean validarDNI(String dni) throws PersistenciaException {
      if (dni != null | !dni.equals("")) {
         return usuarioModelo.validarDNI(dni);
      } else {
         throw new PersistenciaException("No se permite un dni vacio");
      }
   }

   /**
    * Metodo para evaluar la entrada de datos
    * 
    * @param usuario a evaluar
    * @throws PersistenciaException controlado
    */
   public void validarCampos(Usuario usuario) throws PersistenciaException {
      if (usuario == null || usuarioModelo.buscar(usuario.getDni()) == null)
         throw new PersistenciaException("Error");
   }

}
