package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.modelo.Sqlite;

public class SqliteTest {
    Sqlite sqlite;

    @BeforeEach
    public void setUp(){
        if(sqlite==null)
            sqlite=new Sqlite();
    }

    @Test
    public void crearTest(){
        assertEquals("Creado con exito", sqlite.crear(), "No se conecta");
    }
}
