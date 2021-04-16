package excepciones;

public class NumeroExceptions extends Exception {

   /**
    * Esto hay que incluirlo obligatoriamente para que no de error
    */
   private static final long serialVersionUID = 1L;

   /**
    * Constructor de la exception con mensaje
    * 
    * @param mensaje descriptivo
    */
   public NumeroExceptions(String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor de la exception con mensaje
    * 
    * @param mensaje   descriptivo
    * @param exception descriptiva
    */
   public NumeroExceptions(String mensaje, Exception exception) {
      super(mensaje, exception);
   }
}
