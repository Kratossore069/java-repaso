package es.iesptocruz.victor.controlador;

import es.iesptocruz.victor.excepciones.BbddException;
import es.iesptocruz.victor.modelo.BbddMySql;

public class MySQLController {
    BbddMySql mysqlModelo;

    /**
     * Constructor por defecto
     */
    public MySQLController() {
        mysqlModelo = new BbddMySql("admin","admin");
    }

    /**
     * Funcion que ejecuta una sentencia sql en MySql
     * @param sql sentencia
     * @return exito o no
     * @throws BbddException controlado
     */
    public String ejecutarCodigo(String sql) throws BbddException {
        String respuesta = null;
        if (sql != null || sql != "")
            respuesta = mysqlModelo.ejecutarSentencia(sql);
        return respuesta;
    }
}
