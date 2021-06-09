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
    * Metodo para aniadir a partir de un dni
    * @param dni a insertar
    * @throws PersistenciaException controlado
    */
   public void aniadirUsuario(String dni) throws PersistenciaException{
      validarDni(dni);
      usuarioModelo.insertar(dni);
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
    * Funcion que busca por dni
    * @param dni a buscar
    * @return si existe o no
    * @throws PersistenciaException controlado
    */
   public Usuario buscarUsuario(String dni) throws PersistenciaException{
      if(dni==null || dni.isEmpty()){
         throw new PersistenciaException("El dni no puede estar vacio o ser nulo");
      }
      return usuarioModelo.buscar(dni);
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
    * Metodo para actualizar por un dni
    * @param dni a buscar
    * @throws PersistenciaException error
    */
   public void actualizaUsuario(String dni) throws PersistenciaException{
      validarDni(dni);
      usuarioModelo.actualizar(dni);
   }

   /**
    * Metodo para evaluar la entrada de datos
    * @param Usuario a evaluar
    * @throws PersistenciaException controlado
    */
   public void validarCampos(Usuario usuario) throws PersistenciaException{
      if(usuario.getNombre()==null || usuario.getDni()==null)
         throw new PersistenciaException("El nombre o el dni no deben ser nulos.");
   }

   /**
    * Metodo que valida el dni insertado
    * @param dni a validar
    * @throws PersistenciaException error
    */
   public void validarDni(String dni) throws PersistenciaException{
      if(dni.isEmpty() || dni.length()>9 || dni.length()<9 || dni==null)
         throw new PersistenciaException("HAY UN PROBLEMA INSERTANDO EL DNI");
   }
   
}
