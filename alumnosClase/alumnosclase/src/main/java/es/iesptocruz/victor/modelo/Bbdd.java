package es.iesptocruz.victor.modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public abstract class Bbdd {
    private String url = null;
    private Connection connection = null;
    private String vehiculo = null;
    private String password = null;
    private String driver = null;
    private static final String CREATE_TABLE_ALUMNOS = "CREATE TABLE if not exists Alumno (" + " nombre varchar(255),"
            + " apellido varchar(255)," + " numero int" + ");";

    /**
     * Constructor por defecto
     * 
     * @param url      de la bbdd
     * @param usuario  de la bbdd
     * @param password de la bbdd
     * @param driver   de la bbdd
     * @throws PersistenciaException
     */
    public Bbdd(String url, String usuario, String password, String driver) throws PersistenciaException {
        this.url = url;
        this.vehiculo = usuario;
        this.password = password;
        this.driver = driver;
        update(CREATE_TABLE_ALUMNOS);
    }

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * 
     * @return conexion abierta
     * @throws PersistenciaException
     */
    private Connection getConnection() throws PersistenciaException {
        if (connection == null) {
            try {
                Class.forName(driver);
                if (vehiculo != null && password != null) {
                    connection = DriverManager.getConnection(url, vehiculo, password);
                } else {
                    connection = DriverManager.getConnection(url);
                }
            } catch (ClassNotFoundException | SQLException exception) {
                throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
            }
        }
        return connection;
    }

    /**
     * Funcion que realiza una consulta sobre una sentencia sql dada
     * 
     * @param sql de la consulta
     * @return lista resultados (0..n) Usuasios
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Alumno> buscar(String sql) throws PersistenciaException {
        ArrayList<Alumno> lista = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setNumero(resultSet.getInt("numero"));
                lista.add(alumno);
            }
        } catch (SQLException exception) {
            throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
        } finally {
            closeConecction(connection, statement, resultSet);
        }
        return lista;
    }

    /**
     * Metodo encargado de realizar las inserciones/modificaciones/eliminacion de la
     * BBDD
     * 
     * @param sql con la sentencia
     * @throws PersistenciaException error controlado
     */
    public void update(String sql) throws PersistenciaException {
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException exception) {
            throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
        } finally {
            closeConecction(connection, statement, null);
        }
    }

    /**
     * Funcion que muestra datos por pantalla
     * @param sql sentencia a crear
     * @return resultados en String
     * @throws PersistenciaException
     * @throws SQLException
     */
    public String updateSelect(String sql) throws PersistenciaException, SQLException{
        Statement statement = null;
        ResultSet resultSet=null;
        String resultado=null;

        connection = getConnection();
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                while (resultSet.next()) {
                    resultado=resultSet.getString("nombre");
                    resultado+=resultSet.getString("apellido");
                    resultado+=resultSet.getInt("numero");
                }
            }
        return resultado;
    }

    /**
     * Metodo encargado de realizar el cierre de la conexion con la BBDD
     * 
     * @param connection contra la BBDD
     * @param statement  de la operacion
     * @param resultSet  resultado
     * @throws PersistenciaException error controlado
     */
    private void closeConecction(Connection connection, Statement statement, ResultSet resultSet)
            throws PersistenciaException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error cerrando la sesion con la BBDD");
        }
    }

    /**
     * Metodo para aniadir un alumno a la bbdd
     * 
     * @param alumno a insertar
     * @throws PersistenciaException controlado
     */
    public void add(Alumno alumno) throws PersistenciaException {
        String sql = "insert into Alumno values(" + alumno.getNombre() + "," + alumno.getApellido() + ""
                + alumno.getNumero() + ");";
        update(sql);
    }

    /**
     * Metodo para eliminar un registro de la bbdd
     * 
     * @param alumno a eliminar
     * @throws PersistenciaException controlado
     */
    public void remove(Alumno alumno) throws PersistenciaException {
        String sql = "delete from Alumno where nombre like '%" + alumno.getNombre() + "%';";
        update(sql);
    }

    /**
     * Funcion que busca si existe en alumno
     * 
     * @param alumno a buscar
     * @throws PersistenciaException controlado
     */
    public void existe(Alumno alumno) throws PersistenciaException {
        String sql = "select * from Alumno where nombre like '%" + alumno.getNombre() + "%';";
        update(sql);
    }

    /**
     * Metodo que actualiza el numero de un alumno
     * 
     * @param alumno a buscar
     * @param numero que cambiar
     * @throws PersistenciaException controlado
     */
    public void actualizar(Alumno alumno, int numero) throws PersistenciaException {
        String sql = "update Alumno set numero=" + numero + " where nombre like %" + alumno.getNombre() + "%;";
        update(sql);
    }

    /**
     * Funcion que retorna lo agregado en la bbdd
     * @return String con lso datos de la bbdd
     * @throws SQLException controlado
     * @throws PersistenciaException controlado
     */
    public String mostrarTodo() throws PersistenciaException, SQLException{
        String sql = "select * from Alumno";
        return updateSelect(sql);
    }

    /**
     * Funcion que retorna el numero de registros
     * @return numero de registros
     * @throws PersistenciaException controlado
     * @throws SQLException controlado
     */
    public String numeroRegistros() throws PersistenciaException, SQLException{
        String sql="select count(*) from Alumno";
        return updateSelect(sql);
    }
}