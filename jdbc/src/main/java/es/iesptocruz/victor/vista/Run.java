package es.iesptocruz.victor.vista;

import java.io.IOException;

import es.iesptocruz.victor.modelo.BbddSqlite;

public class Run {

    public static void main(String[] args) throws IOException {
        BbddSqlite sqlite = new BbddSqlite();
        sqlite.crearDB();
    }
}
