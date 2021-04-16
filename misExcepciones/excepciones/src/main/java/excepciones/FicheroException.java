package excepciones;

public class FicheroException extends Exception{
    /**
    * Esto hay que incluirlo obligatoriamente para que no de error
    */
   private static final long serialVersionUID = 1L;

   /**
    * Constructor de la exception con mensaje
    * 
    * @param mensaje descriptivo
    */
   public FicheroException(String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor de la exception con mensaje
    * 
    * @param mensaje   descriptivo
    * @param exception descriptiva
    */
   public FicheroException(String mensaje, Exception exception) {
      super(mensaje, exception);
   }
}
