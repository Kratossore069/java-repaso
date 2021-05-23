package es.iesptocruz.victor.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.excepciones.FicheroException;
import es.iesptocruz.victor.excepciones.PersistenciaException;

public class AlumnoModelo {

    SqliteDB persistencia;

    /**
     * Constructor por defecto
     * @throws PersistenciaException controlado
     */
    public AlumnoModelo() throws PersistenciaException{
        persistencia=new SqliteDB("jdbc:sqlite:usuario.db", null, null, "org.sqlite.JDBC");
    }

    /**
     * Metodo para aniadir un alumno a la lista
     * @param alumno a insertar
     * @throws FicheroException controlado
     * @throws PersistenciaException controlado
     */
    public void aniadir(Alumno alumno) throws FicheroException, PersistenciaException{
        persistencia.add(alumno);
    }

    /**
     * Metodo para eliminar un alumno de la lista
     * @param alumno a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Alumno alumno) throws PersistenciaException{
        persistencia.remove(alumno);
    }

    /**
     * Metodo que modifica un alumno
     * @param alumno a modificar
     * @param numero a cambiar
     * @throws PersistenciaException controlado
     */
    public void modificar(Alumno alumno, int numero) throws PersistenciaException{
        persistencia.actualizar(alumno,numero);
    }

    /**
     * Funcion para buscar y mostrar un usuario
     * @param alumno a buscar
     * @return resultado o no
     * @throws PersistenciaException controlado
     */
    public ArrayList<Alumno> buscar(String identificador) throws PersistenciaException{
        return persistencia.buscar(identificador);
    }

    /**
     * Funcion que muestra todo lo de la lista
     * @return String con los datos de la bbdd
     * @throws PersistenciaException controlado
     * @throws SQLException controlado
     */
    public String listarTodo() throws PersistenciaException, SQLException {
        return persistencia.mostrarTodo();
    }

    /**
     * Funcion que cuenta el numero de registros dentro de la bbdd
     * @return numero de registros
     * @throws PersistenciaException controlado
     * @throws SQLException controlado
     */
    public String recuento() throws PersistenciaException, SQLException {
        return persistencia.numeroRegistros();
    }
}
