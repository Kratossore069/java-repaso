package es.iesptocruz.victor;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.BaseDatos;

public class BaseDatosTest{

    BaseDatos bdd;
    
    @BeforeEach
    public void setUp(){
        if(bdd==null)
            bdd=new BaseDatos();
    }

    /**
     * Test que conecta a la bdd
     */
    @Test
    public void conectarTest(){
        try{
            assertEquals("Conectado",bdd.connect(),"Debe conectar a la bdd");
        }catch(Exception ex){
            fail("Error al conectar");
        }
    }

    /**
     * Test que crea una tabla
     */
    @Test
    public void tablaTest(){
        try {
            assertEquals("Exito",bdd.crearTabla(),"Debe eliminar la tabla");   
        } catch (Exception e) {
            fail("Error");
        }        
    }

    /**
     * Test que elimina una tabla
     */
    @Test
    public void eliminarTest(){
        try {
            assertEquals("Exito",bdd.eliminarTabla(),"Debe eliminar la tabla");    
        } catch (Exception e) {
            fail("Error");
        }        
    }
}
