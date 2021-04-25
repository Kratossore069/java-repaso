package excepciones;

public class MisExcepciones extends Exception{
    
    /**
     * Excepcion propia
     * @param mensaje de error
     */
    public MisExcepciones(String mensaje){
        super(mensaje);
    }
}
