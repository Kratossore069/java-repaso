package es.iesptocruz.victor;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.BDDSqlite;



public class SQliteTest{

    BDDSqlite bdd;
    
    @BeforeEach
    public void setUp(){
        if(bdd==null)
            bdd=new BDDSqlite();
    }

    /**
     * Test que conecta a la bdd
     */
    @Test
    public void conectarTest(){
        try{
            assertEquals("Conectado",bdd.connectSQlite(),"Debe conectar a la bdd");
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
