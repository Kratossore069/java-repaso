package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaTest {

    Lista lista;
    String dato = "valor1";
    int posicion=1;

    @BeforeEach
    public void setUp() {
        if (lista == null) {
            lista = new Lista();
        }
        lista.insertarDatos(dato);
    }

    @AfterEach
    public void afterUp() {

    }

    @Test
    public void insertarTest() {
        assertTrue(lista.existe(dato),"Elemento no encontrado");
    }

    // @Test
    // public void eliminarTest(){
    //     assertNotNull(lista.eliminarElemento(posicion),"Error al eliminar");
    // }

}
