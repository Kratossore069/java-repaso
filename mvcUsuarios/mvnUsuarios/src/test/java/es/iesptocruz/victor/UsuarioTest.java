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
public class UsuarioTest 
{
    UsuarioControlador userController;
    Usuario user;

    @Before
    public void setUp() throws UsuarioException{
        if(userController==null){
            userController=new UsuarioControlador();
            user=new Usuario("Pablo", "Jacinto", 25, "001");
            userController.insertar(user);
        }
    }

    @After
    public void setDown(){
        userController.eliminarTodo();
    }

    /**
     * Test que muestra todos los usuarios insertados
     */
    @Test
    public void mostrarTodoTest(){
        String salida="001 { nombre='Pablo', apellidos='Jacinto', edad='25', identificador='001'}";
        assertEquals("Debe salir un usuario",salida, userController.mostrarTodo());
    }

    /**
     * Test que muestra el numero maximo de usuarios
     */
    @Test
    public void numeroTest(){
        assertEquals("Debe haber solo un usuario",1, userController.numeroTotal());
    }

    /**
     * Test que demuestra que funciona el eliminar usuarios
     * @throws UsuarioException error controlado
     */
    @Test
    public void eliminarTest() throws UsuarioException{
        userController.eliminar(user);
        assertEquals("No debe haber usuarios",0, userController.numeroTotal());
    }
}
