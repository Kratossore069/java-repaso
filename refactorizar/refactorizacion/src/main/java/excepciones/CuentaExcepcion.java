package excepciones;

public class CuentaExcepcion extends Exception{
    
    /**
     * Excepcion propia
     * @param mensaje de error
     */
    public CuentaExcepcion(String mensaje){
        super(mensaje);
    }
}
