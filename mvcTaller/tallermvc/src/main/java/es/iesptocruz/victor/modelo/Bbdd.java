package es.iesptocruz.victor.modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.BbddException;

public class Bbdd {
    private String dbURLSQlite=null;
    private String dbURLMySql=null;
    private Connection conn = null;
    private String usuario = null;
    private String password = null;
    private String driver=null;

    /**
     * Constructor generico para las conexiones
     * @param usuario de la Bbdd
     * @param password de la Bbdd
     */
    public Bbdd(String usuario,String password){
        this.usuario=usuario;
        this.password=password;
    }

    /**
     * Funcion que conecta a auna Bbdd
     * @param usuario a ingresar, si no hay colocar null
     * @param password a ingresar, si no hay colocar null
     * @return exito o no
     * @throws BbddException controlado
     * @throws SQLException controlado
     */
    public String conectarBbdd(String usuario,String password) throws BbddException, SQLException{
        String resultado=null;
        if(usuario==null && password==null){
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            resultado="Exito al conectar";
        }else{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pruebas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",usuario,password);
            resultado="Exito al conectar";
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
     * Funcion que crea una tabla en la Bbdd
     * 
     * @return mensaje de exito
     * @throws BbddException controlado
     */
    public String crearTabla() throws BbddException {
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " id integer PRIMARY KEY,\n" + " name text NOT NULL\n"
                + ");";
        return ejecutarCodigo(sql);
    }

    /**
     * Funcion que elimina una tabla de la Bbdd
     * 
     * @return mensaje de exito
     * @throws BbddException controlado
     */
    public String eliminarTabla() throws BbddException {
        String sql = "drop table if exists employees";
        return ejecutarCodigo(sql);
    }

    /**
     * Metodo que se encarga de ejecutar las sentencias sql
     * 
     * @param sql sentencia a ejecutar
     * @return mensaje de exito o no
     * @throws BbddException controlado
     */
    public String ejecutarCodigo(String sql) throws BbddException {
        String res = null;
        try {
            conn = DriverManager.getConnection(dbURLSQlite);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BbddException("Error", e);
        }
        return res;
    }

    /**
     * Funcion que resuelve si existe o no una tabla
     * @param connection con la Bbdd
     * @param tableName nombre de la tabla
     * @return true or false
     * @throws SQLException controlado
     */
    public boolean tableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] { "TABLE" });
        return resultSet.next();
    }

    /**
     * Funcion que crea una tabla de prueba
     * 
     * @return exito o no
     * @throws BbddException controlado
     */
    public String createTable() throws BbddException {
        String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), "
                + " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))";
        return ejecutarSentencia(sql);
    }

    /**
     * Funcion que ejecuta la sentencia que se le envie
     * 
     * @param sql sentencia que ejecutar
     * @return exito o no al ejecutar la consulta
     * @throws BbddException controlado
     */
    public String ejecutarSentencia(String sql) throws BbddException {
        String res = null;
        try {
            conn = DriverManager.getConnection(dbURLMySql, usuario, password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BbddException("Error", e);
        }
        return res;
    }

    /**
     * Metodo para crear la base de datos
     * @throws IOException controlado
     */
    public void crearDBSqlite() throws IOException{
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File("db.sh"));
        Process process = processBuilder.start();
        process.destroy();
    }

    /**
     * Funcion que crea una tabla en la Bbdd
     * 
     * @return mensaje de exito
     * @throws BbddException controlado
     */
    public String crearTablaSqlite() throws BbddException {
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " id integer PRIMARY KEY,\n" + " name text NOT NULL\n"
                + ");";
        return ejecutarCodigo(sql);
    }

    /**
     * Funcion que elimina una tabla de la Bbdd
     * 
     * @return mensaje de exito
     * @throws BbddException controlado
     */
    public String eliminarTablaSqlite() throws BbddException {
        String sql = "drop table if exists employees";
        return ejecutarCodigo(sql);
    }

    /**
     * Metodo que se encarga de ejecutar las sentencias sql
     * 
     * @param sql sentencia a ejecutar
     * @return mensaje de exito o no
     * @throws BbddException controlado
     */
    public String ejecutarCodigoSqlite(String sql) throws BbddException {
        String res = null;
        try {
            conn = DriverManager.getConnection(dbURLSQlite);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BbddException("Error", e);
        }
        return res;
    }
}

