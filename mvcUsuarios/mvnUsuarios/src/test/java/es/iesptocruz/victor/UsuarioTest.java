package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.controlador.UsuarioControlador;
import es.iesptocruz.victor.exceptions.UsuarioException;

/**
 * Unit test for simple App.
 */
public class UsuarioTest {
    UsuarioControlador userController;
    Usuario user;
    Usuario nuevoUser;

    @Before
    public void setUp() throws UsuarioException {
        if (userController == null) {
            userController = new UsuarioControlador();
            user = new Usuario("Pablo", "Jacinto", 25, "001");
            nuevoUser = new Usuario("Victor", "Casas", 30, "002");
            userController.insertar(user);
        }
    }

    @After
    public void setDown() {
        userController.eliminar();
    }

    /**
     * Test que muestra todos los usuarios insertados
     */
    @Test
    public void mostrarTest() {
        String salida = "{ nombre='Pablo', apellidos='Jacinto', edad='25', identificador='001'}";
        assertEquals("Debe salir un usuario", salida, userController.mostrar());
    }

    /**
     * Test que muestra el numero maximo de usuarios
     */
    @Test
    public void numeroUsuariosTest() {
        assertEquals("Debe haber solo un usuario", 1, userController.numeroUsuarios());
    }

    /**
     * Test que demuestra que funciona el eliminar usuarios
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void eliminarTest() throws UsuarioException {
        userController.eliminar(user);
        assertEquals("No debe haber usuarios", 0, userController.numeroUsuarios());
    }

    /**
     * Test que muestra que funciona aniadir un usuario
     */
    @Test
    public void aniadirTest() throws UsuarioException {
        userController.insertar(nuevoUser);
        assertEquals("Debe haber dos usuarios", 2, userController.numeroUsuarios());
    }

    /**
     * Test que muestra que se encuentra un usuario en la lista
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void buscarTest() throws UsuarioException {
        assertEquals("Debe encontrar un usuario", true, userController.buscar(user));
    }

    /**
     * Test que muestra falso si no encuentra un usuario
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void noBuscarTest() throws UsuarioException {
        assertEquals("Debe salir falso", false, userController.buscar(nuevoUser));
    }

    /**
     * Test que muestra la info de un usuario
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void mostrarUsuarioTest() throws UsuarioException {
        String datosEsperados = "{ nombre='Pablo', apellidos='Jacinto', edad='25', identificador='001'}";
        assertEquals("Deben salir unos datos", datosEsperados, userController.mostrar("001"));
    }

    /**
     * Test que no muestra nada si no encuentra el usuario
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void noMostrarTest() throws UsuarioException {
        try {
            assertEquals("No debe salir nada", "Usuario no encontrado", userController.mostrar("002"));
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    /**
     * Test que muestra la modificacion de los datos
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void modificarTest() throws UsuarioException {
        userController.modificar(user);
        String datosEsperados = "{ nombre='Modificado', apellidos='Jacinto', edad='25', identificador='001'}";
        assertEquals("Deberia cambiar el nombre", datosEsperados, userController.mostrar("001"));
    }

    /**
     * Test que muestra que falla si no se modifica un usuario que no existe en la
     * lista
     * 
     * @throws UsuarioException error controlado
     */
    @Test
    public void noModificarTest() throws UsuarioException {
        try {
            userController.modificar(nuevoUser);
            String datosEsperados = "001 { nombre='Modificado', apellidos='Jacinto', edad='25', identificador='001'}";
            assertEquals("Deberia cambiar el nombre", datosEsperados, userController.mostrar("001"));
        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
