package es.iesptocruz.victor.modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.BDDException;

public class BDDSqlite extends BDD{

    private String dbURL;
    private Connection conn = null;

    /**
     * Constructor por defecto de sqlite
     */
    public BDDSqlite() {
        super(null, null);
    }

    /**
     * Funcion que conecta con la base de datos SQLite
     * 
     * @return conectado o no
     * @throws BDDException controlado
     */
    public String connect() throws BDDException, SQLException {
        String resultado = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            resultado = "Conectado";
        } catch (SQLException e) {
            throw new BDDException("Error al conectar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return resultado;
    }

    /**
     * Metodo para crear la base de datos
     * @throws IOException controlado
     */
    public void crearDB() throws IOException{
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File("db.sh"));
        Process process = processBuilder.start();
        process.destroy();
    }

    /**
     * Funcion que crea una tabla en la bdd
     * 
     * @return mensaje de exito
     * @throws BDDException controlado
     */
    public String crearTabla() throws BDDException {
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " id integer PRIMARY KEY,\n" + " name text NOT NULL\n"
                + ");";
        return ejecutarCodigo(sql);
    }

    /**
     * Funcion que elimina una tabla de la bdd
     * 
     * @return mensaje de exito
     * @throws BDDException controlado
     */
    public String eliminarTabla() throws BDDException {
        String sql = "drop table if exists employees";
        return ejecutarCodigo(sql);
    }

    /**
     * Metodo que se encarga de ejecutar las sentencias sql
     * 
     * @param sql sentencia a ejecutar
     * @return mensaje de exito o no
     * @throws BDDException controlado
     */
    public String ejecutarCodigo(String sql) throws BDDException {
        String res = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }
}
