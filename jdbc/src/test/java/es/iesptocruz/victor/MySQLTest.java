package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.BDDMySql;

public class MySQLTest {
    BDDMySql dbMysql;

    @BeforeEach
    public void setUp(){
        if(dbMysql==null)
            dbMysql=new BDDMySql("admin","admin");
    }

    /**
     * Test que conecta con la bdd de MySql
     */
    @Test
    public void conectarTest(){
        try {
            assertEquals("Conectado",dbMysql.connectMySql("admin", "admin"),
            "Debe conectar a la bdd");
        } catch (Exception e) {
            fail("Error al conectar a la BDD de MYSQL");
        } 
    }

    /**
     * Test que crea una tabla de prueba
     */
    @Test
    public void crearTablaTest(){
        try{
            assertEquals("Exito",dbMysql.createTable(),"Debe conectar a la bdd");
        }catch(Exception ex){
            fail("Error al crear la tabla de prueba");
        }
    }
}
