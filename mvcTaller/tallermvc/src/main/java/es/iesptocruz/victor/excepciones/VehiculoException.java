package es.iesptocruz.victor.excepciones;

public class VehiculoException extends Exception{
    
    /**
     * Constructor que muestra un mensaje
     * @param mensaje de la excepcion creada
     */
    public VehiculoException(String mensaje){
        super(mensaje);
    }
}
