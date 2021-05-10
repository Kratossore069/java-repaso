package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.BDDException;

public class BaseDatos {

    private String dbURL;
    private String usuario=null;
    private String password=null;
    private Connection conn = null;
    private Statement stmt = null;

    /**
     * Constructor por defecto de sqlite
     */
    public BaseDatos() {
        dbURL = "jdbc:sqlite:test.db";
    }

    /**
     * Constructor de MySQL
     * @param usuario de MySQL
     * @param password de MySQL
     */
    public BaseDatos(String usuario,String password){
        dbURL="jdbc:mysql://localhost:3306/ved_project";
        this.usuario=usuario;
        this.password=password;
    }

    /**
     * Funcion que conecta con la base de datos SQLite
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
     * Conectar a BDD de MySQL
     * @param usuario de MySQL
     * @param password de MySQL
     * @return mensaje de exito o no 
     * @throws BDDException error controlado
     */
    public String connect(String usuario,String password) throws BDDException {
        String resultado=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dbURL, usuario, password);
            resultado="Conectado";
        } catch (SQLException e) {
            throw new BDDException("Error al conectar a MySQL", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new BDDException("Error al cerrar MySQL", ex);
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
             + " name text NOT NULL\n" + ");";
        return ejecutarCodigo(sql);
    }

    /**
     * Funcion que elimina una tabla de la bdd
     * @return mensaje de exito
     * @throws BDDException controlado
     */
    public String eliminarTabla() throws BDDException{
        String sql = "drop table if exists employees";
        return ejecutarCodigo(sql);
    }

    /**
     * Metodo que se encarga de ejecutar las sentencias sql
     * @param sql sentencia a ejecutar
     * @return mensaje de exito o no
     * @throws BDDException controlado
     */
    public String ejecutarCodigo(String sql) throws BDDException{
        String res=null;
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res="Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }
}
