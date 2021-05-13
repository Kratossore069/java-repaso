package es.iesptocruz.victor.controlador;

import es.iesptocruz.victor.excepciones.BbddException;
import es.iesptocruz.victor.modelo.BbddSqlite;

public class SQliteController {
    BbddSqlite sqliteModelo;

    /**
     * Constructor por defecto
     */
    public SQliteController() {
        sqliteModelo = new BbddSqlite();
    }

    /**
     * Funcion que se asegura de que la sentencia sql no este vacia
     * @param sql sentencia
     * @return exito o no
     * @throws BbddException controlado
     */
    public String ejecutarCodigo(String sql) throws BbddException {
        String resultado="";
        if (sql != null || sql != "")
            resultado=sqliteModelo.ejecutarCodigo(sql);
        return resultado;
    }
}
