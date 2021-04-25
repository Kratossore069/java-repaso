package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import excepciones.MisExcepciones;

/**
 * Unit test for simple App.
 */
public class CuentaTest {
    
    Cuenta cuenta;

    @Before
    public void setUp(){
        if(cuenta==null){
            cuenta=new Cuenta("Victor","001",100,5);
        }
    }

    /**
     * Test que demuestra que ingresar dinero funciona
     * pero hay problema a la hora de hacer con tipo double
     * @throws MisExcepciones controlado
     */
    @Test
    public void ingresarTest() throws MisExcepciones{
        cuenta.ingresar(200);
        assertEquals("Debe salir 300",300, cuenta.getSaldo());
    }

    /**
     * Test que controla una excepcion cuando se intenta
     * ingresar un valor negativo, cosa que no se permite
     * @throws MisExcepciones controlado
     */
    @Test
    public void noIngresarTest() throws MisExcepciones{
        try{
            cuenta.ingresar(-200);
            assertEquals("Debe salir 300",300, cuenta.getSaldo());
        }catch(Exception ex){
            ex.getMessage();
        }
    }

    /**
     * Test que muestra que se retira dinero
     * @throws MisExcepciones controlado
     */
    @Test
    public void retirarTest() throws MisExcepciones{
        cuenta.retirar(50);
        assertEquals("Debe salir 50",50, cuenta.getSaldo());
    }

    /**
     * Test que controla que no se pueda retirar una
     * cantidad negativa de dinero
     * @throws MisExcepciones controlado
     */
    @Test
    public void noRetirarTest() throws MisExcepciones{
        try{
            cuenta.retirar(-50);
            assertEquals("Debe salir 50",50, cuenta.getSaldo());
        }catch(Exception ex){
            ex.getMessage();
        }
    }

    /**
     * Test que demuestra que no se puede retirar una cantidad
     * mayor a la de su saldo base
     * @throws MisExcepciones controlado
     */
    @Test
    public void saldoInsuficiente() throws MisExcepciones{
        try{
            cuenta.retirar(400);
            assertEquals("Debe salir 50",50, cuenta.getSaldo());
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
