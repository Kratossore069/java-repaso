package es.ejemplos.jpexposito.controlador;

import java.sql.SQLException;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exception.PersistenciaException;
import es.ejemplos.jpexposito.modelo.UsuarioModelo;

public class UsuarioControlador {

   UsuarioModelo usuarioModelo;

   public UsuarioControlador() throws PersistenciaException {
      usuarioModelo = new UsuarioModelo();
   }

   /**
    * Metodo para aniadir una Usuario
    * @param Usuario a aniadir
    * @throws PersistenciaException controlado
    */
   public void aniadirUsuario(Usuario usuario) throws PersistenciaException{
      validarCampos(usuario);
      usuarioModelo.insertar(usuario);
   }

   /**
    * Metodo para eliminar una Usuario
    * @param Usuario a eliminar
    * @throws PersistenciaException controlado
    */
   public void eliminarUsuario(Usuario usuario) throws PersistenciaException{
      validarCampos(usuario);
      usuarioModelo.eliminar(usuario);
   }

   /**
    * Metodo para mostrar los campos de la bbdd
    * @throws PersistenciaException error
    * @throws SQLException controlado
    */
   public void mostrarTodo() throws PersistenciaException, SQLException{
      usuarioModelo.mostrar();
   }

   /**
    * Funcion que busca una Usuario como parametro
    * @param Usuario a buscar
    * @return la Usuario
    * @throws PersistenciaException controlado
    */
   public Usuario buscarUsuario(Usuario usuario) throws PersistenciaException{
      validarCampos(usuario);
      return usuarioModelo.buscar(usuario.getDni());
   }

   /**
    * Metodo que actualiza una Usuario
    * @param Usuario a actualizar
    * @throws PersistenciaException controlado
    */
   public void actualizaUsuario(Usuario usuario) throws PersistenciaException{
      validarCampos(usuario);
      usuarioModelo.actualizar(usuario);
   }

   /**
    * Metodo para evaluar la entrada de datos
    * @param Usuario a evaluar
    * @throws PersistenciaException controlado
    */
   public void validarCampos(Usuario usuario) throws PersistenciaException{
      if(usuario==null || usuarioModelo.buscar(usuario.getDni())==null)
         throw new PersistenciaException("Error");
   }
   
}
