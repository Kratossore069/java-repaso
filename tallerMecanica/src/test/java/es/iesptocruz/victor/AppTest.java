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
        assertEquals("El tamaño de la lista es incorrecto", 0, taller.tamanioCoches());
    }

    /**
     * Buscar un coche y mostrar resultado
     */
    @Test
    public void existeTest(){
        assertEquals("El elemento debería existir en la lista", true,
         taller.existeCoche(matricula));
    
    }

    @Test
    public void noExisteTest(){
        assertEquals("El elemento no debería existir en la lista", false,
         taller.existeCoche("1234"));
    }

    @Test
    public void busquedaTest(){
        assertEquals("El elemento no está en la lista", matricula,
         taller.buscarMatricula(matricula));
    }

    /**
     * Test de no encontrar una matrícula
     */
    @Test
    public void noEncuentraTest(){
        assertEquals("La matrícula no debería existir", null,
         taller.buscarMatricula("12ABC"));
    }

    
}
