package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
     * Test de no insertar frutas
     */
    @Test
    public void noInsertarTest(){
        gestion.insertar(10.2f, "Verde", 10.2f, null);
        assertEquals(1, gestion.inventario(),"Un solo registro");
    }

    /**
     * Test de inventario
     */
    @Test
    public void inventarioTest(){
        insertarTest();
    }

    /**
     * Test de no inventario
     */
    @Test
    public void noInventarioTest(){
        gestion.eliminar(new Fruta(10.2f, "Verde", 10.2f, "Pomelo"));
        assertEquals(0, gestion.inventario(),"No hay registros");
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
     * Test de no buscar frutas, debe dar falso
     */
    @Test
    public void noBuscarTest(){
        assertFalse(gestion.buscar(new Fruta(10.2f, "Verde", 10.2f, "Manzano")));
    }

    /**
     * Test que elimina las piezas de fruta
     */
    @Test
    public void eliminarTest(){
        gestion.eliminar(new Fruta(10.2f, "Verde", 10.2f, "Pomelo"));
        assertEquals(0, gestion.inventario(),"No hay registros");
    }

    /**
     * Test que muestra que no se elimina algo que no existe
     */
    @Test
    public void noEliminarTest(){
        gestion.eliminar(new Fruta(10.2f, "Verde", 10.2f, "Manzano"));
        assertEquals(1, gestion.inventario(),"Hay un registro");
    }
}
