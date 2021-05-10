package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.excepciones.BDDException;
import es.iesptocruz.victor.modelo.BDDMySql;

public class MySQLTest {
    BDDMySql mysql;

    @BeforeEach
    public void setUp(){
        if(mysql==null)
            mysql=new BDDMySql();
    }

    /**
     * Test que conecta con la bdd de MySql
     */
    @Test
    public void conectarTest(){
        try {
            assertEquals("Conectado",mysql.connect(),"Debe conectar a la bdd");
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
            assertEquals("Exito",mysql.createTable(),"Debe conectar a la bdd");
        }catch(Exception ex){
            fail("Error al crear la tabla de prueba");
        }
    }
}
