package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.BbddMySql;

public class MySQLTest {
    BbddMySql dbMysql;

    @BeforeEach
    public void setUp(){
        if(dbMysql==null)
            dbMysql=new BbddMySql("admin","admin");
    }

    /**
     * Test que conecta con la Bbdd de MySql
     */
    @Test
    public void conectarTest(){
        try {
            assertEquals("Conectado",dbMysql.connectMySql("admin", "admin"),
            "Debe conectar a la Bbdd");
        } catch (Exception e) {
            fail("Error al conectar a la Bbdd de MYSQL");
        } 
    }

    /**
     * Test que crea una tabla de prueba
     */
    @Test
    public void crearTablaTest(){
        try{
            assertEquals("Exito",dbMysql.createTable(),"Debe conectar a la Bbdd");
        }catch(Exception ex){
            fail("Error al crear la tabla de prueba");
        }
    }
}
