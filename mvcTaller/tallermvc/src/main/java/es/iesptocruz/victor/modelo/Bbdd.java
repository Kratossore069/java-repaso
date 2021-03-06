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

import es.iesptocruz.victor.api.Vehiculo;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public abstract class Bbdd {
    private String url = null;
    private Connection connection = null;
    private String vehiculo = null;
    private String password = null;
    private String driver = null;

    /**
     * Constructor por defecto
     * 
     * @param url      de la bbdd
     * @param usuario  de la bbdd
     * @param password de la bbdd
     * @param driver   de la bbdd
     */
    public Bbdd(String url, String usuario, String password, String driver) {
        this.url = url;
        this.vehiculo = usuario;
        this.password = password;
        this.driver = driver;
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
    private ArrayList<Vehiculo> buscar(String sql) throws PersistenciaException {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setIdentificador(resultSet.getString("identificador"));
                vehiculo.setNombre(resultSet.getString("nombre"));
                vehiculo.setApellidos(resultSet.getString("apellidos"));
                vehiculo.setEdad(resultSet.getInt("edad"));
                lista.add(vehiculo);
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
    * Metodo encargado de realizar el cierre de la conexion con la BBDD
    * 
    * @param connection contra la BBDD
    * @param statement  de la operacion
    * @param resultSet  resultado
    * @throws PersistenciaException error controlado
    */
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
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
}
