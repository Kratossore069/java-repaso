package es.iesptocruz.victor.excepciones;

public class BDDException extends Exception{
    /**
     * Excepcion personalizada
     * @param mensaje de error
     */
    public BDDException(String mensaje){
        super(mensaje);
    }

    /**
     * Excepcion con mensaje
     * @param mensaje de error
     * @param e excepcion
     */
    public BDDException(String mensaje, Exception e){
        super(mensaje+e);
    }
}
