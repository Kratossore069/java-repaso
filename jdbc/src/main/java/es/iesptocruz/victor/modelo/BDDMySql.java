package es.iesptocruz.victor.modelo;

import java.sql.Connection;

public class BDDMySql extends BDD {

    /**
     * Constructor de MySQL
     */
    public BDDMySql(String usuario, String password) {
        super(usuario, password);
    }
}
