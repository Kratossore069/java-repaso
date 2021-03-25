package es.iesptocruz.victor;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
    Palabras palabras;
    String sustantivo="Casa";

    @Before
    public void setUp(){
        if(palabras==null){
            palabras=new Palabras();
        }
        palabras.insertar(sustantivo);
    }

    @After
    public void setDown(){
        palabras.eliminar(sustantivo);
    }

    /**
     * Test de insertar registros en la lista
     */
    @Test
    public void insertarTest(){
        assertEquals("La lista debería tener un registro",
        1, palabras.numeroPalabras());
    }

    /**
     * Test de NO insertar registros
     */
    @Test
    public void noInsertarTest(){
        palabras.eliminar(sustantivo);
        assertEquals("La lista no debería tener más registros",
        0, palabras.numeroPalabras());
    }

    /**
     * Test del numero de palabras
     */
    @Test
    public void numeroPalabrasTest(){
        assertEquals("La lista debería tener un registro",
        1, palabras.numeroPalabras());
    }

    /**
     * Test para errar el numero de palabras
     */
    @Test
    public void errorNumeroPalabrasTest(){
        assertNotEquals("No debería haber 5 palabras insertadas",
        5, palabras.numeroPalabras());
    }

    /**
     * Test para comprobar que hay palabras iguales
     */
    @Test
    public void igualesTest(){
        assertEquals("Debería aparecer un registro",
        1, palabras.palabrasIguales(sustantivo));
    }

    /**
     * Comprobar que hay palabras que no coinciden
     */
    @Test
    public void noIgualesTest(){
        assertNotEquals("No debería coincidir la palabra, el registro debe ser 0",
        10, palabras.palabrasIguales(sustantivo));
    }

    /**
     * Comprobamos el eliminar
     */
    @Test
    public void eliminarTest(){
        setDown();
        assertEquals("No debería haber registros",
        0, palabras.numeroPalabras());
    }    

    /**
     * Comprobamos que no se elimina nada
     */
    @Test
    public void noEliminarTest(){
        assertFalse("No debería eliminar", palabras.eliminar("Perro"));
    }
}
