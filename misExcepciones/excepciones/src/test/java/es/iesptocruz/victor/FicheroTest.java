package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.FicheroException;

public class FicheroTest {
    Fichero fichero;

    @Before
    public void setUp() throws FicheroException{
        if(fichero==null){
            fichero=new Fichero();
            fichero.crearFichero("algo.txt");
        }
    }

    @After
    public void setDown() throws FicheroException{
        try{
            fichero.eliminoFichero("algo.txt");
        }catch(Exception ex){
            throw new FicheroException("Error en el setDown");
        } 
    }

    /**
     * Test que muestra si existe el fichero
     */
    @Test
    public void existeTest(){
        assertEquals("Debe existir", true, fichero.existe("algo.txt"));
    }

    /**
     * Test que muestra si se lee un fichero
     * @throws FicheroException error controlado
     */
    @Test
    public void leerTest() throws FicheroException{
        assertEquals(true,fichero.sePuedeLeer("algo.txt"));
    }

    /**
     * Muestra si existe texto en un documento
     * @throws FicheroException error controlado
     */
    @Test
    public void mostrarTest() throws FicheroException{
        assertEquals("",fichero.mostrarDocumento("algo.txt"));
    }

    /**
     * Test de si puede ser escrito un documento si existe
     * @throws FicheroException error controlado
     */
    @Test
    public void redactarTest() throws FicheroException{
        assertEquals(true,fichero.sePuedeRedactar("algo.txt"));
    }

    /**
     * Test de escribir en un documento
     * @throws FicheroException error controlado
     */
    @Test
    public void escribirTest() throws FicheroException{
        assertEquals("Escrito con éxito",fichero.redactarDocumento("algo.txt"));
    }

    /**
     * Test que muestra informacion sobre el documento
     * @throws FicheroException controlado
     */
    @Test
    public void datosTest() throws FicheroException{
        assertEquals("algo.txt /home/victor/java-repaso/misExcepciones/excepciones/algo.txt",
        fichero.datosFichero("algo.txt"));
    }
}
