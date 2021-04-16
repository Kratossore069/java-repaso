package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import excepciones.NumeroExceptions;

public class CalculadoraTest {
    Calculadora cal;

    @Before
    public void setUp() {
        if (cal == null) {
            cal = new Calculadora();
        }
    }

    /**
     * Test que prueba una division
     */
    @Test
    public void divisionTest(){
        try {
            assertEquals("Debe dar 5", 5, cal.division(5, 1));
        } catch (NumeroExceptions e) {
            fail("No debe generar una excepcion de NumeroExceptions: "
            +e.getMessage());
        }
    }

    /**
     * Test de dividir entre 0
     */
    @Test
    public void divisionPorCero(){
        try {
            assertEquals("Debe dar 1", 1, cal.division(5, 0));
        } catch (NumeroExceptions e) {
            assertTrue("No se ha obtenido el mensaje esperado",
            e.getMessage().contains("No se puede dividir entre 0"));
        }
    }
}
