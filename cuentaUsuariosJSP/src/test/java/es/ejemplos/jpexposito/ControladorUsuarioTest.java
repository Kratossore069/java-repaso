package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.controlador.UsuarioControlador;

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
