package es.iesptocruz.victor.modelo;

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

    public String listarTodo() throws PersistenciaException {
        return persistencia.mostrarTodo();
    }

    public int recuento() {
        return 0;
    }
}
