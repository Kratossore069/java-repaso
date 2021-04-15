package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import excepciones.Exceptions;

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
     * @throws Exceptions si hay un problema, esta controlando dividir entre 0
     */
    @Test
    public void divisionTest() throws Exceptions {
        assertEquals("Debe dar 1", 1, cal.division(5, 5));
    }
}
