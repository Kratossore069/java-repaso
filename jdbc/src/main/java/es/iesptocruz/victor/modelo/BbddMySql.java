package es.iesptocruz.victor.modelo;

import java.sql.Connection;

public class BbddMySql extends Bbdd {

    /**
     * Constructor de MySQL
     */
    public BbddMySql(String usuario, String password) {
        super(usuario, password);
    }
}
