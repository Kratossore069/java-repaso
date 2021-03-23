package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.iesptocruz.victor.modelo.Taller;

/**
 * Unit test for simple App.
 */
public class AppTest {

    Taller taller;
    String matricula;

    @Before
    public void setUp(){
        if(taller==null){
            taller=new Taller();
        }
        matricula="123A";
        taller.aniadirCoche(matricula);
    }

    @After
    public void setDown(){
        taller.eliminarCoche(matricula);
    }

    /**
     * Si inserta bien los matriculas nuevos
     */
    @Test
    public void aniadirTest(){
        assertEquals(1, taller.tamanioCoches());
    }

    /**
     * Eliminar matriculas del taller
     */
    @Test
    public void eliminarTest(){   
        taller.eliminarCoche(matricula);
        assertEquals(0, taller.tamanioCoches());
    }

    /**
     * Buscar un coche y mostrar resultado
     */
    @Test
    public void existeTest(){
        assertEquals(true, taller.existeCoche(matricula));
    }

    @Test
    public void busquedaTest(){
        assertEquals(matricula, taller.buscarMatricula(matricula));
    }
}
