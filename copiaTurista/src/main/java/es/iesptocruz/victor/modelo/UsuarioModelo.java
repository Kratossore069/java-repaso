package es.iesptocruz.victor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public class UsuarioModelo {

   DdBbSqLite persistencia;
   private static final String TABLA = "Persona";
   private static final String CLAVE = "Dni";

   /**
    * Constructor por defecto
    * 
    * @throws PersistenciaException controlado
    */
   public UsuarioModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
   }

   /**
    * Funcion para validar un DNI de una persona
    * 
    * @param dni a validar
    * @return true or false
    */
   public boolean validarDNI(String dni) {
      boolean correcto = false;
      Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
      Matcher matcher = pattern.matcher(dni);

      if (matcher.matches()) {
         String letra = matcher.group(2);
         String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
         int index = Integer.parseInt(matcher.group(1));
         index = index % 23;
         String reference = letras.substring(index, index + 1);
         if (reference.equalsIgnoreCase(letra)) {
            correcto = true;
         } else {
            correcto = false;
         }
      } else {
         correcto = false;
      }
      return correcto;
   }

   /**
    * Inserta en la tabla nueva informacion
    * 
    * @param usuario que insertar
    * @throws PersistenciaException controlado
    */
   public void insertar(Usuario usuario) throws PersistenciaException {
      String sql = "insert into " + TABLA + "(dni,nombre) values(" + usuario.getDni() + "," + usuario.getNombre() + ")";
      persistencia.update(sql);
   }

   /**
    * Elimina una columna a partir de un identificador aniadido
    * 
    * @param usuario a insertar
    * @throws PersistenciaException controlado
    */
   public void eliminar(Usuario usuario) throws PersistenciaException {
      String sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = '" + usuario.getDni() + "'";
      persistencia.update(sql);
   }

   /**
    * Metodo que busca un elemento entero a partir de un codigo
    * 
    * @param codigo a buscar en la bbdd
    * @return el elemento encontrado
    * @throws PersistenciaException controlado
    */
   public Usuario buscar(String codigo) throws PersistenciaException {
      return (Usuario) persistencia.buscarElemento(codigo);
   }

   /**
    * Metodo que actualiza una tabla en la bbdd
    * 
    * @param usuario informacion sobre la Usuario turistica
    * @throws PersistenciaException controlado
    */
   public void actualizar(Usuario usuario) throws PersistenciaException {
      String sql = "update " + TABLA + " set dni='" + usuario.getDni() + "' where nombre like %'" + usuario.getNombre()
            + "'%";
      persistencia.update(sql);
   }
}
