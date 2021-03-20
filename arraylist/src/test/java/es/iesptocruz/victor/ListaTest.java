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
        lista.insertar(dato);
    }

    @AfterEach
    public void afterUp() {
        lista.eliminar(dato);
    }

    @Test
    public void insertarTest() {
        assertTrue(lista.existe(dato),"Elemento no encontrado");
    }

    @Test
    public void buscarTest() {
        String datoBuscar=lista.buscar(dato);
        assertTrue(datoBuscar.equals(dato), "Elemento no esperado");
    }

}
