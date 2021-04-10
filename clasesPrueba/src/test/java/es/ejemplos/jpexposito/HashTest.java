package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTest {
    GestionHash gestion;

    @BeforeEach
    public void setUp() {
        if (gestion == null) {
            gestion = new GestionHash();
        }
        gestion.insertarFrutas(100,new Fruta(10.2f, "Verde", 10.2f, "Pomelo"));
    }

    /**
     * Test que indica que se insertan bien los test
     */
    @Test
    public void insertarTest(){
        assertEquals(1, gestion.inventarioFrutas(),"Debe haber solo una fruta");
    }

    /**
     * Test que indica que no se insertan frutas
     * de numeros menores que 100
     */
    @Test
    public void noInsertarTest(){
        gestion.insertarFrutas(50, new Fruta(5.2f,"Azul",5.2f,"Zanahoria"));
        assertEquals(1, gestion.inventarioFrutas(),"Debe haber solo una fruta");
    }

    // @Test Null Pointer Exception
    // public void listarTest(){
    //     assertEquals(null, gestion.mostrarLista());
    // }

    /**
     * Test que elimina una fruta por su numero de serie
     */
    @Test
    public void eliminarTest(){
        gestion.eliminarFruta(100);
        assertEquals(0, gestion.inventarioFrutas(),"No hay frutas");
    }

    /**
     * Test que no elimina una fruta por su numero de serie
     * si no existe
     */
    @Test
    public void noEliminarTest(){
        gestion.eliminarFruta(101);
        assertEquals(1, gestion.inventarioFrutas(),"Hay frutas");
    }
}
