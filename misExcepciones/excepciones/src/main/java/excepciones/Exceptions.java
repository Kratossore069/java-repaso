package excepciones;

public class Exceptions extends Exception {

   /**
    * Esto hay que incluirlo obligatoriamente para que no de error
    */
   private static final long serialVersionUID = 1L;

   /**
    * Constructor de la exception con mensaje
    * 
    * @param mensaje descriptivo
    */
   public Exceptions(String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor de la exception con mensaje
    * 
    * @param mensaje   descriptivo
    * @param exception descriptiva
    */
   public Exceptions(String mensaje, Exception exception) {
      super(mensaje, exception);
   }
}
