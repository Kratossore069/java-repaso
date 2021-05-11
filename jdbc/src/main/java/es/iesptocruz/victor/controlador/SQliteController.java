package es.iesptocruz.victor.controlador;

import es.iesptocruz.victor.excepciones.BDDException;
import es.iesptocruz.victor.modelo.BDDSqlite;

public class SQliteController {
    BDDSqlite sqliteModelo;

    /**
     * Constructor por defecto
     */
    public SQliteController() {
        sqliteModelo = new BDDSqlite();
    }

    /**
     * Funcion que se asegura de que la sentencia sql no este vacia
     * @param sql sentencia
     * @return exito o no
     * @throws BDDException controlado
     */
    public String ejecutarCodigo(String sql) throws BDDException {
        String resultado="";
        if (sql != null || sql != "")
            resultado=sqliteModelo.ejecutarCodigo(sql);
        return resultado;
    }
}
