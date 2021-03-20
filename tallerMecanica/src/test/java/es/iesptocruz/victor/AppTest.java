package es.iesptocruz.victor;

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

    @Test
    public void numeroCochesTest(){
        assertTrue(taller.numeroCoches(),"Debería dar 0");
    }
}
