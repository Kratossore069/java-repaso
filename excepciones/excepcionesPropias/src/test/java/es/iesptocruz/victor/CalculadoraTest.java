package es.iesptocruz.victor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculadoraTest 
{
    Calculadora cal;

    @BeforeEach
    public void setUp(){
        if(cal==null){
            cal=new Calculadora();
        }
    }

    @Test
    public void divisionTest()
    {
        int dividendo=4;
        int divisor=2;
        int resultado=dividendo/divisor;
    
    }
}
