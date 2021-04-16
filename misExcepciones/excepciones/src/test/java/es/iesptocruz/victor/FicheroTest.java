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
}
