package es.iesptocruz.victor.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonaModelo {

  Bbdd persistencia;

  public PersonaModelo() {
    persistencia = new Bbdd();
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
}
