package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sqlite {
    Connection connection = null;
    String url = null;

    public Sqlite() {
        url = "jdbc:sqlite:usuario.sqlite";
    }

    /**
     * Funcion que crea la bbdd
     * 
     * @return mensaje de exito o no
     */
    public String crear() {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();
        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] { TABLE });
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString("TABLE_NAME"));
            }
            if (!listaTablas.contains(TABLE_NAME)) {
                // Crear tabla cuenta
                String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS CUENTA (" + " codigo VARCHAR(50) PRIMARY KEY,"
                        + "cliente VARCHAR(9) NOT NULL," + "email VARCHAR(50) NOT NULL," + "saldo DOUBLE NOT NULL);";
                update(sqlCrearTabla);
            }

        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConecction(connection, null, resultSet);
        }
    }

    public void update(String sql) throws PersistenciaException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
           connection= getConnection();
           statement = connection.prepareStatement(sql);
           statement.executeUpdate();
        } catch (SQLException exception) {
           throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
        } finally {
           closeConecction(connection, statement, null);
        }
     }

    public Connection getConnection() throws PersistenciaException {
        Connection connection = null;
  
        try {
           Class.forName(driver);
           if (usuario != null && password != null) {
              connection = DriverManager.getConnection(urlConexion, usuario, password);
           } else {
              connection = DriverManager.getConnection(urlConexion);
           }
        } catch (ClassNotFoundException | SQLException exception) {
           throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
        }
        
        return connection;
     }
}
