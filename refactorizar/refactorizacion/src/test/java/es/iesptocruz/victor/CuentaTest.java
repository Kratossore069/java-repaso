package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import excepciones.CuentaExcepcion;

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
     * @throws CuentaExcepcion controlado
     */
    @Test
    public void ingresarTest(){
        try{
            cuenta.ingresar(200);
            assertEquals("Debe salir 300",300, cuenta.getSaldo());
        }catch(Exception ex){
            fail("Error no controlado");
        }    
    }

    /**
     * Test que controla una excepcion cuando se intenta
     * ingresar un valor negativo, cosa que no se permite
     *  controlado
     */
    @Test
    public void noIngresarTest(){
        try{
            cuenta.ingresar(-200);
        }catch(Exception ex){
            assertTrue("No se ha obtenido el mensaje esperado",
            ex.getMessage().contains("negativa"));
        }
    }

    /**
     * Test que muestra que se retira dinero
     *  controlado
     */
    @Test
    public void retirarTest(){
        try{
            cuenta.retirar(50);
            assertEquals("Debe salir 50",50, cuenta.getSaldo());
        }catch(Exception ex){
            fail("Error no controlado");
        } 
    }

    /**
     * Test que controla que no se pueda retirar una
     * cantidad negativa de dinero
     *  controlado
     */
    @Test
    public void noRetirarTest(){
        try{
            cuenta.retirar(-50);
        }catch(Exception ex){
            assertTrue("No se ha obtenido el mensaje esperado",
            ex.getMessage().contains("negativa"));
        }
    }

    /**
     * Test que demuestra que no se puede retirar una cantidad
     * mayor a la de su saldo base
     *  controlado
     */
    @Test
    public void saldoInsuficiente(){
        try{
            cuenta.retirar(400);
        }catch(Exception ex){
            assertTrue("No se ha obtenido el mensaje esperado",
            ex.getMessage().contains("suficiente"));
        }
    }
}
