package es.iesptocruz.victor.excepciones;

public class PersistenciaException extends Exception{
    /**
     * Excepcion personalizada
     * @param mensaje de error
     */
    public PersistenciaException(String mensaje){
        super(mensaje);
    }

    /**
     * Excepcion con mensaje
     * @param mensaje de error
     * @param e excepcion
     */
    public PersistenciaException(String mensaje, Exception e){
        super(mensaje+e);
    }
}
