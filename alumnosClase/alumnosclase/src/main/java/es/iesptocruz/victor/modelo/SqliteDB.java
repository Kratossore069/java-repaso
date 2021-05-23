package es.iesptocruz.victor.modelo;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class SqliteDB extends Bbdd{

    public SqliteDB(String url, String usuario, String password, String driver) throws PersistenciaException {
        super(url, usuario, password, driver);
    }

    
    
}
