package es.iesptocruz.victor.excepciones;

public class AlumnoException extends Exception{
    /**
     * Constructor que muestra un mensaje
     * @param mensaje de la excepcion creada
     */
    public AlumnoException(String mensaje){
        super(mensaje);
    }

    /**
    * Constructor de la exception con mensaje
    * @param mensaje   descriptivo
    * @param exception descriptiva
    */
   public AlumnoException(String mensaje, Exception exception) {
    super(mensaje, exception);
 }

}
