package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTest {
    GestionHash gestion;
    Fruta fruta;

    @BeforeEach
    public void setUp() {
        if (gestion == null) {
            gestion = new GestionHash();
        }
        fruta = new Fruta(1, 10.2f, "Verde", 10.2f, "Pomelo");
        gestion.insertarFruta(fruta);
    }

    /**
     * Test que indica que se insertan bien los test
     */
    @Test
    public void insertarTest() {
        assertEquals(1, gestion.inventarioFrutas(), "Debe haber solo una fruta");
    }

    /**
     * Test que indica que no se insertan frutas de numeros menores que 100
     */
    @Test
    public void noInsertarTest() {
        gestion.insertarFruta(new Fruta(1, 5.2f, "Azul", 5.2f, "Zanahoria"));
        assertEquals(1, gestion.inventarioFrutas(), "Debe haber solo una fruta");
    }

    /**
     * Test para comprobar la salida de información
     */
    @Test
    public void listarTest() {
        String resultadoEsperado = "1 Nombre:Pomelo, Color:Verde, Peso:10.2, Precio:10.2";
        assertEquals(resultadoEsperado, gestion.mostrarLista(), "No se ha obtenido el resultado esperado");
    }

    /**
     * Test que demuestra que sale nulo si no hay registros
     */
    @Test
    public void noListarTest() {
        gestion.eliminarFruta(1);
        assertEquals("", gestion.mostrarLista(),"No se ha obtenido la lista vacía");
    }

    /**
     * Test que elimina una fruta por su numero de serie
     */
    @Test
    public void eliminarTest() {
        gestion.eliminarFruta(fruta.getIdentificador());
        assertEquals(0, gestion.inventarioFrutas(), "No hay frutas");
    }

    /**
     * Test que no elimina una fruta por su numero de serie si no existe
     */
    @Test
    public void noEliminarTest() {
        gestion.eliminarFruta(101);
        assertEquals(1, gestion.inventarioFrutas(), "Hay frutas");
    }
}
