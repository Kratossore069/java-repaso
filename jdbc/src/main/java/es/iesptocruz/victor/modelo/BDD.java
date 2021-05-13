package es.iesptocruz.victor.modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.BDDException;

public class BDD {
    private String dbURLSQlite=null;
    private String dbURLMySql=null;
    private Connection conn = null;
    private String usuario = null;
    private String password = null;

    /**
     * Constructor generico para las conexiones
     * @param usuario de la bdd
     * @param password de la bdd
     */
    public BDD(String usuario,String password){
        dbURLSQlite="jdbc:sqlite:test.db";
        dbURLMySql="jdbc:mysql://localhost/pruebas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.usuario=usuario;
        this.password=password;
    }

    /**
     * Funcion que conecta a auna bdd
     * @param usuario a ingresar, si no hay colocar null
     * @param password a ingresar, si no hay colocar null
     * @return exito o no
     * @throws BDDException controlado
     * @throws SQLException controlado
     */
    public String conectarBDD(String usuario,String password) throws BDDException, SQLException{
        String resultado=null;
        if(usuario==null && password==null){
            resultado=connectSQlite();
        }else{
            resultado=connectMySql(usuario, password);
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
            conn = DriverManager.getConnection(dbURLSQlite);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }

    /**
     * Funcion que conecta con Mysql
     * @param usuario del sistema
     * @param password del sistema
     * @return exito o no
     * @throws BDDException controlado
     * @throws SQLException controlado
     */
    public String connectMySql(String usuario,String password) throws BDDException, SQLException {
        String resultado = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURLMySql, usuario, password);
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
     * Funcion que conecta con la base de datos SQLite
     * @return conectado o no
     * @throws BDDException controlado
     */
    public String connectSQlite() throws BDDException, SQLException {
        String resultado = null;
        try {
            conn = DriverManager.getConnection(dbURLSQlite);
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
     * Funcion que resuelve si existe o no una tabla
     * @param connection con la bdd
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
     * @throws BDDException controlado
     */
    public String createTable() throws BDDException {
        String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), "
                + " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))";
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
            conn = DriverManager.getConnection(dbURLMySql, usuario, password);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
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
     * Funcion que crea una tabla en la bdd
     * 
     * @return mensaje de exito
     * @throws BDDException controlado
     */
    public String crearTablaSqlite() throws BDDException {
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
    public String eliminarTablaSqlite() throws BDDException {
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
    public String ejecutarCodigoSqlite(String sql) throws BDDException {
        String res = null;
        try {
            conn = DriverManager.getConnection(dbURLSQlite);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            res = "Exito";
        } catch (Exception e) {
            throw new BDDException("Error", e);
        }
        return res;
    }
}
