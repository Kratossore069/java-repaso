package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.BDDException;

public class BaseDatos {

    private String dbURL;
    private Connection conn = null;
    private Statement stmt = null;

    /**
     * Constructor por defecto
     */
    public BaseDatos() {
        dbURL = "jdbc:sqlite:test.db";
    }

    /**
     * Funcion que conecta con la base de datos
     * 
     * @return conectado o no
     * @throws BDDException controlado
     */
    public String connect() throws BDDException {
        String resultado=null;
        try {
            conn = DriverManager.getConnection(dbURL);
            resultado="Conectado";
        } catch (SQLException e) {
            throw new BDDException("Error al conectar", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new BDDException("Error al cerrar", ex);
            }
        }
        return resultado;
    }

    /**
     * Funcion que crea una tabla en la bdd
     * @return mensaje de exito
     * @throws BDDException controlado
     */
    public String crearTabla() throws BDDException {
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n" +
             " id integer PRIMARY KEY,\n"
             + " name text NOT NULL,\n" + " capacity real\n" + ");";
        String res=null;
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            stmt.execute(sql);
            res="Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }

    /**
     * Funcion que elimina una tabla de la bdd
     * @return exito o no
     * @throws BDDException controlado
     */
    public String eliminarTabla() throws BDDException {
        String sql = "drop table if exists employees";
        String res=null;
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            stmt.execute(sql);
            res="Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }
}
