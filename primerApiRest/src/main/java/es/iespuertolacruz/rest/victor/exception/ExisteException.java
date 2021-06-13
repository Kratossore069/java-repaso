package es.iespuertolacruz.rest.victor.exception;

public class ExisteException extends Exception{

    public ExisteException() {
        super("El alumno existe en el sistema");
    }

}
