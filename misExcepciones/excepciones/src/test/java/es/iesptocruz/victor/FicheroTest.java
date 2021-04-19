package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.FicheroException;

public class FicheroTest {
    private static final String ALGO_TXT = "algo.txt";
    Fichero fichero;

    @Before
    public void setUp() throws FicheroException{
        if(fichero==null){
            fichero=new Fichero();
            fichero.crear(ALGO_TXT);
        }
    }

    @After
    public void setDown() throws FicheroException{
        try{
            fichero.eliminar(ALGO_TXT);
        }catch(Exception ex){
            throw new FicheroException("Error en el setDown");
        } 
    }

    /**
     * Test que muestra si existe el fichero
     */
    @Test
    public void existeTest(){
        assertEquals("Debe existir", true, fichero.existe(ALGO_TXT));
    }

    /**
     * Test que muestra si se lee un fichero
     * @throws FicheroException error controlado
     */
    @Test
    public void leerTest() throws FicheroException{
        assertEquals(true,fichero.permisoLectura(ALGO_TXT));
    }

    /**
     * Muestra si existe texto en un documento
     * @throws FicheroException error controlado
     */
    @Test
    public void mostrarTest() throws FicheroException{
        assertEquals("",fichero.mostrar(ALGO_TXT));
    }

    /**
     * Test de si puede ser escrito un documento si existe
     * @throws FicheroException error controlado
     */
    @Test
    public void redactarTest() throws FicheroException{
        assertEquals(true,fichero.sePuedeRedactar(ALGO_TXT));
    }

    /**
     * Test de escribir en un documento
     * @throws FicheroException error controlado
     */
    @Test
    public void escribirTest(){
        try {
            fichero.escribir(ALGO_TXT,"texto");
        } catch (FicheroException e) {
            fail("Se ha producido un error durante la escritura del fichero");
        }
    }

    /**
     * Test que muestra informacion sobre el documento
     * @throws FicheroException controlado
     */
    @Test
    public void datosTest() throws FicheroException{
        assertEquals("algo.txt /home/victor/java-repaso/misExcepciones/excepciones/algo.txt",
        fichero.info(ALGO_TXT));
    }
}
