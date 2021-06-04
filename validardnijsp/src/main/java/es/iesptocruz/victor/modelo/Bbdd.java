package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.iesptocruz.victor.excepciones.PersistenciaException;

public class Bbdd {  

    String url;
    Connection connection;

    /**
     * Constructor por defecto
     */
    public Bbdd(){
        url="jdbc:sqlite:usuarios.db";
    }
  
    /**
     * Metodo que crea una nueva bbdd con SQLite
     * @throws PersistenciaException controlado
     */
    public void crear() throws PersistenciaException {  
   
        try {  
            connection = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            throw new PersistenciaException("Error al crear la bbdd", e);
        } 
    }  
}  
