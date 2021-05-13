package es.iesptocruz.victor;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.BbddSqlite;



public class SQliteTest{

    BbddSqlite Bbdd;
    
    @BeforeEach
    public void setUp(){
        if(Bbdd==null)
            Bbdd=new BbddSqlite();
    }

    /**
     * Test que conecta a la Bbdd
     */
    @Test
    public void conectarTest(){
        try{
            assertEquals("Conectado",Bbdd.connectSQlite(),"Debe conectar a la Bbdd");
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
            assertEquals("Exito",Bbdd.crearTabla(),"Debe eliminar la tabla");   
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
            assertEquals("Exito",Bbdd.eliminarTabla(),"Debe eliminar la tabla");    
        } catch (Exception e) {
            fail("Error");
        }        
    }
}
