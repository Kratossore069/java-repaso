package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.BDDException;

public class BDDMySql {
    private String dbURL;
    private String usuario = null;
    private String password = null;
    private Connection conn = null;

    /**
     * Constructor de MySQL
     */
    public BDDMySql() {
        dbURL = "jdbc:mysql://localhost/pruebas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        usuario = "admin";
        password = "admin";
    }

    /**
     * Conectar a BDD de MySQL
     * 
     * @return mensaje de exito o no
     * @throws BDDException error controlado
     */
    public String connect() throws BDDException, SQLException {
        String resultado = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, usuario, password);
            resultado = "Conectado";
        } catch (SQLException | ClassNotFoundException e) {
            throw new BDDException("Error al conectar a MySQL", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return resultado;
    }

    /**
     * Funcion que crea una tabla de prueba
     * @return exito o no
     * @throws BDDException controlado
     */
    public String createTable() throws BDDException{
        String sql="CREATE TABLE IF NOT EXISTS REGISTRATION " +
        "(id INTEGER not NULL, " +
        " first VARCHAR(255), " + 
        " last VARCHAR(255), " + 
        " age INTEGER, " + 
        " PRIMARY KEY ( id ))";
        return ejecutarSentencia(sql);
    }

    /**
     * Funcion que ejecuta la sentencia que se le envie
     * 
     * @param sql sentencia que ejecutar
     * @return exito o no al ejecutar la consulta
     * @throws BDDException controlado
     */
    public String ejecutarSentencia(String sql) throws BDDException {
        String res = null;
        try {
            conn = DriverManager.getConnection(dbURL,usuario,password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }
}
