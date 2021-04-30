package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.iesptocruz.victor.vista.AppVista;

public class MainTest {
    AppVista menu;

    @Before
    public void setUp(){
        //menu=(menu==null) ? new AppVista() : null;
    }

    @Test
    public void introducirTest(){
        assertEquals("hola", AppVista.introducirDatos());
    }
}
