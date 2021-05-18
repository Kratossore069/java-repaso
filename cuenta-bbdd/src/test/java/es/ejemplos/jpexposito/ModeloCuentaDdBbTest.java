package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.modelo.CuentaModelo;

public class ModeloCuentaDdBbTest {

    CuentaModelo cuentaModelo;

    @BeforeAll 
    public void beforeAll() {
        if (cuentaModelo == null) {
            try {
                cuentaModelo = new CuentaModelo();
            } catch (Exception e) {
                fail("Se ha producido un error en el indicio de la BBDD");
            }
        }
    }

    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }
}
