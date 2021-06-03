package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class Bbdd {  

    /**
     * Constructor por defecto
     */
    public Bbdd(){}
  
    /**
     * Metodo que crea una nueva bbdd con SQLite
     * @throws PersistenciaException controlado
     */
    public void crear() throws PersistenciaException {  
   
        String url = "jdbc:sqlite:usuarios.db";  
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (SQLException e) {  
            throw new PersistenciaException("Error al crear la bbdd", e);
        }  
    }  
}  
