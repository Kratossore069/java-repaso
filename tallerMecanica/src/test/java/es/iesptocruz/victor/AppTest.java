package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.iesptocruz.victor.modelo.Taller;

/**
 * Unit test for simple App.
 */
public class AppTest {

    Taller taller;

    @Before
    public void setUp(){
        if(taller==null){
            taller=new Taller();
        }
    }

    /**
     * Determinar el número de coches introducidos
     */
    @Test
    public void numeroTest(){
        assertEquals(0, taller.numeroCoches());
    }

    /**
     * Si inserta bien los coches nuevos
     */
    @Test
    public void aniadirTest(){
        String matricula="123A";
        taller.aniadirCoche(matricula);
        assertEquals(1, taller.numeroCoches());
    }

    /**
     * Eliminar coches del taller
     */
    @Test
    public void eliminarTest(){
        String matricula="123A";
        taller.aniadirCoche(matricula);
        taller.eliminarCoche(matricula);
        assertEquals(0, taller.numeroCoches());
    }

    /**
     * Buscar un coche y mostrar resultado
     */
    @Test
    public void buscarTest(){
        taller.aniadirCoche("matricula");
        assertEquals("[matricula]", taller.buscarCoche("matricula"));
    }
}
