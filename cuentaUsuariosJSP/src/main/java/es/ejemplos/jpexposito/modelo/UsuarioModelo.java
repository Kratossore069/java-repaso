package es.ejemplos.jpexposito.modelo;

import java.sql.SQLException;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class UsuarioModelo{

   DdBbSqLite persistencia;
   private static final String TABLA  = "Usuario";
   private static final String CLAVE  = "Dni";
   
   public UsuarioModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
   }

   public void insertar(Usuario usuario) throws PersistenciaException {
      String sql="insert into "+TABLA+" (dni, nombre) values ('"+usuario.getDni()+"', '"+usuario.getNombre()+"');";
      persistencia.update(sql);
   }

   public void insertar(String dni) throws PersistenciaException {
      String sql="insert into "+TABLA+" (dni, nombre) values ('"+dni+"', 'Antonio');";
      persistencia.update(sql);
   }

   public void eliminar(Usuario usuario) throws PersistenciaException {
      String sql = "DELETE FROM "+TABLA+" WHERE "+CLAVE+" = '" + usuario.getDni() + "'";
      persistencia.update(sql);
   }

   public Usuario buscar(String codigo) throws PersistenciaException {
      return (Usuario) persistencia.buscarElemento(codigo);
   }

   public void actualizar(Usuario usuario) throws PersistenciaException {
      String sql="update Usuario set nombre='"+usuario.getNombre()+
      "', dni='"+usuario.getDni()+"' where dni='"+usuario.getDni()+"'";
      persistencia.update(sql);
   }

   public void actualizar(String dni) throws PersistenciaException {
      String sql="update Usuario set nombre='cambiado', dni='cambiado' where dni='"+dni+"'";
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
