package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    GestionFruta gestion;

    @BeforeEach
    public void setUp() {
        if (gestion == null) {
            gestion = new GestionFruta();
        }
        gestion.insertar(10.2f, "Verde", 10.2f, "Pomelo");
    }

    /**
     * Test de insertar frutas
     */
    @Test
    public void insertarTest(){
        assertEquals(1, gestion.inventario(),"Un solo registro");
    }

    /**
     * Test de buscar frutas que da true porque
     * existe del setUp la fruta ingresada
     */
    @Test
    public void buscarTest(){
        assertTrue(gestion.buscar(new Fruta(10.2f, "Verde", 10.2f, "Pomelo")));
    }

    /**
     * Test que elimina las piezas de fruta
     */
    @Test
    public void eliminarTest(){
        gestion.eliminar(new Fruta(10.2f, "Verde", 10.2f, "Pomelo"));
        assertEquals(0, gestion.inventario(),"No hay registros");
    }
}
