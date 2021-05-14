package es.iesptocruz.victor.excepciones;

public class FicheroException extends Exception{
    /**
     * Constructor que muestra un mensaje
     * @param mensaje de la excepcion creada
     */
    public FicheroException(String mensaje){
        super(mensaje);
    }

    /**
    * Constructor de la exception con mensaje
    * @param mensaje   descriptivo
    * @param exception descriptiva
    */
   public FicheroException(String mensaje, Exception exception) {
    super(mensaje, exception);
 }

}

