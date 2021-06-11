package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.controlador.UsuarioControlador;
import es.iesptocruz.victor.exception.PersistenciaException;
import es.iesptocruz.victor.modelo.UsuarioModelo;

public class ModelousuarioDdBbTest {

    static UsuarioModelo usuarioModelo;
    Usuario usuario = null;

    @BeforeAll
    public static void beforeAll() {
        if (usuarioModelo == null) {
            try {
                usuarioModelo = new UsuarioModelo();
            } catch (Exception e) {
                fail(e.getMessage());
            }

        }
    }

    @BeforeEach
    public void crearusuario() {
        usuario = new Usuario("Víctor", "45123658U");
        try {
            usuarioModelo.insertar(usuario);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error insertando la usuario");
        }
    }

    @AfterEach
    public void eliminarusuario() {
        if (usuario != null) {
            try {
                usuarioModelo.eliminar(usuario);
            } catch (PersistenciaException e) {
                fail("Se ha producido un error eliminando la usuario");
            }
        }
    }

    /**
     * Test que busca una usuario
     */
    @Test
    public void buscarusuarioTest() {
        try {
            Usuario usuarioEncontrada = usuarioModelo.buscar(usuario.getDni());
            assertNotNull(usuarioEncontrada, "No se debe de obtener un elemento nulo");
            assertEquals(usuario, usuarioEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del la usuario,e:" + e.getMessage());
        }
    }

    /**
     * Test que actualiza una usuario
     */
    @Test
    public void actualizarusuarioTest() {
        try {
            Usuario usuarioEncontrada = usuarioModelo.buscar(usuario.getDni());
            assertNotNull(usuarioEncontrada, "No se debe de obtener un elemento nulo");
            usuarioEncontrada.setNombre("Pepe");
            usuarioModelo.actualizar(usuarioEncontrada);
            Usuario usuarioActualziada = usuarioModelo.buscar(usuarioEncontrada.getDni());
            assertEquals(usuarioActualziada, usuarioEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del la usuario,e:" + e.getMessage());
        }
    }

    @Test
    public void buscarUsuarioTest() {
        String dni="45125897G";
        try {
            UsuarioControlador userController = new UsuarioControlador();
            Usuario usuario = new Usuario("Victor", dni);
            Usuario userEncontrado = userController.buscarUsuario(usuario);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Test que inserta una nueva usuario en el registro
     */
    @Test
    public void insertarusuarioTest() {
        Usuario usuario2 = new Usuario("Pedro", "41254876Y");
        try {
            usuarioModelo.insertar(usuario2);
            Usuario usuarioEncontrada = usuarioModelo.buscar(usuario2.getDni());
            assertEquals(usuario2, usuarioEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del la usuario,e:" + e.getMessage());
        } finally {
            if (usuario2 != null) {
                try {
                    usuarioModelo.eliminar(usuario2);
                } catch (PersistenciaException e) {
                    fail("No ha sido posible eliminar la usuario creada");
                }
            }
        }
    }

    @Test
    public void mostrarTest() {
        try {
            System.out.println(usuarioModelo.mostrar());
        } catch (Exception e) {
            fail("Error al mostrar");
        }
    }
}
