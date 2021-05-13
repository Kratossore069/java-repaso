package es.iesptocruz.victor.excepciones;

public class BbddException extends Exception{
    /**
     * Excepcion personalizada
     * @param mensaje de error
     */
    public BbddException(String mensaje){
        super(mensaje);
    }

    /**
     * Excepcion con mensaje
     * @param mensaje de error
     * @param e excepcion
     */
    public BbddException(String mensaje, Exception e){
        super(mensaje+e);
    }
}
