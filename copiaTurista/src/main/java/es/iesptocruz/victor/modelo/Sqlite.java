package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class Sqlite {

    /**
     * Metodo que crea una bbdd y una tabla
     * 
     * @throws PersistenciaException controlado
     */
    public String crearTabla() throws PersistenciaException {
        String respuesta = null;
        String url = "jdbc:sqlite:tests.db";

        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n" 
        + "nombre varchar(50)," 
        + "dni varchar(50)" 
        + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            respuesta = "Todo correcto";
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
        return respuesta;
    }
}
