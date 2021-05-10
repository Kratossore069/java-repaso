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

    @Test
    public void conectarTest() throws BDDException, SQLException{
        assertEquals("Conectado",mysql.connect(),"Debe conectar a la bdd");
    }
}
