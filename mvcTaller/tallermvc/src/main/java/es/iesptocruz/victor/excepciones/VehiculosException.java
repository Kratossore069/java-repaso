package es.iesptocruz.victor.excepciones;

import es.iesptocruz.victor.modelo.Vehiculos;

public class VehiculosException extends Exception{
    
    /**
     * Constructor que muestra un mensaje
     * @param mensaje de la excepcion creada
     */
    public VehiculosException(String mensaje){
        super(mensaje);
    }
}
