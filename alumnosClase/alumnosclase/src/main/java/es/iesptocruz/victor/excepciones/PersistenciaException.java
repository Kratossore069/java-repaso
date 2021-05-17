package es.iesptocruz.victor.excepciones;

public class PersistenciaException extends Exception{
    /**
     * Constructor que muestra un mensaje
     * @param mensaje de la excepcion creada
     */
    public PersistenciaException(String mensaje){
        super(mensaje);
    }

    /**
    * Constructor de la exception con mensaje
    * @param mensaje   descriptivo
    * @param exception descriptiva
    */
   public PersistenciaException(String mensaje, Exception exception) {
    super(mensaje, exception);
 }

}
