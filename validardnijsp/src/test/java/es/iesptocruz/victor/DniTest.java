package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.DdBbSqLite;


public class DniTest {

    DdBbSqLite bbdd;

    @BeforeEach
    public void setUp() {
        try{
        if(bbdd==null)
            bbdd=new DdBbSqLite("personas", "dni", "org.sqlite.JDBC", "jdbc:sqlite:personas.db", null, null);
        }catch(Exception ex){
            fail("Error al crear la bbdd "+ex);
        }
    }

    @AfterEach
    public void setDown() {
        
    }

    /**
     * Test que busca una cuenta
     */
    @Test
    public void BbddTest() {
        try{
            bbdd.inicializarTabla("personas");
        }catch(Exception ex){
            fail("Fallo al crear la bbdd "+ex.getMessage());
        }
    }

}
