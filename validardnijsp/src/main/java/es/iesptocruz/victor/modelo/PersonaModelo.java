package es.iesptocruz.victor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class PersonaModelo {

  DdBbSqLite persistencia;
  private static final String TABLA = "PERSONAS";
  private static final String CLAVE = "DNI";

  /**
   * Constructor por defecto
   */
  public PersonaModelo() throws PersistenciaException {
    persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
  }

  public String buscar(String dni) {
    return "Estoy buscando dentro del modelo " + dni;
  }

  /**
   * Funcion para validar un DNI de una persona
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

  //  /**
  //   * Inserta en la tabla nueva informacion
  //   * @param ruta a insertar
  //   * @throws PersistenciaException controlado
  //   */
  //  public void insertar(Ruta ruta) throws PersistenciaException {
  //     String sql = "insert into " + TABLA + "(identificador, nombre, fecha, turistas, telefono, distancia)"
  //           + " values ('" + ruta.getIdentificador() + "','" + ruta.getNombre() + "','" + ruta.getFecha() + "',"
  //           + ruta.getTuristas() + "," + ruta.getTelefono() + "," + ruta.getDistancia() + ")";
  //     persistencia.update(sql);
  //  }

  //  /**
  //   * Elimina una columna a partir de un identificador aniadido
  //   * @param ruta a buscar y eliminar
  //   * @throws PersistenciaException controlado
  //   */
  //  public void eliminar(Ruta ruta) throws PersistenciaException {
  //     String sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = '" + ruta.getIdentificador() + "'";
  //     persistencia.update(sql);
  //  }

  //  /**
  //   * Metodo que busca un elemento entero a partir de un codigo
  //   * 
  //   * @param codigo a buscar en la bbdd
  //   * @return el elemento encontrado
  //   * @throws PersistenciaException controlado
  //   */
  //  public Ruta buscar(String codigo) throws PersistenciaException {
  //     return (Ruta) persistencia.buscarElemento(codigo);
  //  }

  //  /**
  //   * Metodo que actualiza una tabla en la bbdd
  //   * 
  //   * @param ruta informacion sobre la ruta turistica
  //   * @throws PersistenciaException controlado
  //   */
  //  public void actualizar(Ruta ruta) throws PersistenciaException {
  //     String sql = "update " + TABLA + " set identificador = " + ruta.getIdentificador()
  //           + " where identificador like '%" + ruta.getIdentificador() + "%'";
  //     persistencia.update(sql);
  //  }
}
