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
    private Statement stmt = null;

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
}
