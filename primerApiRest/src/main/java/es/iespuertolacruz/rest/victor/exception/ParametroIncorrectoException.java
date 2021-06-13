package es.iespuertolacruz.rest.victor.exception;

public class ParametroIncorrectoException extends Exception{

    public ParametroIncorrectoException(String parametro) {
        super("El parametro introducido no es correcto " +parametro);
    }

}
