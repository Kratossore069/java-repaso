package es.iesptocruz.victor.exceptions;

public class UsuarioException extends Exception{
    /**
     * Excepcion controlada
     * @param mensaje descriptivo
     */
    public UsuarioException(String mensaje){
        super(mensaje);
    }
}
