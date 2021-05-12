package es.iesptocruz.victor.vista;

import java.io.IOException;

import es.iesptocruz.victor.modelo.BDDSqlite;

public class Run {

    public static void main(String[] args) throws IOException {
        BDDSqlite sqlite = new BDDSqlite();
        sqlite.crearDB();
    }
}
