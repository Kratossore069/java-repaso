package es.iesptocruz.victor.controlador;

import es.iesptocruz.victor.excepciones.BDDException;
import es.iesptocruz.victor.modelo.BDDMySql;

public class MySQLController {
    BDDMySql mysqlModelo;

    /**
     * Constructor por defecto
     */
    public MySQLController() {
        mysqlModelo = new BDDMySql("admin","admin");
    }

    /**
     * Funcion que ejecuta una sentencia sql en MySql
     * @param sql sentencia
     * @return exito o no
     * @throws BDDException controlado
     */
    public String ejecutarCodigo(String sql) throws BDDException {
        String respuesta = null;
        if (sql != null || sql != "")
            respuesta = mysqlModelo.ejecutarSentencia(sql);
        return respuesta;
    }
}
