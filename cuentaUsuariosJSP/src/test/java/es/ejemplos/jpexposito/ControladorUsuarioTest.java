package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.controlador.UsuarioControlador;

public class ControladorUsuarioTest {
    
    @Test
    public void buscarTest(){
        Usuario userEncontrado=null;
        String dni="45125487K";
        try{
            UsuarioControlador userController = new UsuarioControlador();
            userEncontrado = userController.buscarUsuario(dni);
        }catch(Exception exception){
            fail("Fallo al buscar el usuario");
        }
    }
    
}
