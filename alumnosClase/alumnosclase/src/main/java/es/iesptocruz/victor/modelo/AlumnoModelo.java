package es.iesptocruz.victor.modelo;

import java.util.ArrayList;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.excepciones.FicheroException;

public class AlumnoModelo {

    SqliteDB persistencia;

    /**
     * Constructor por defecto
     */
    public AlumnoModelo(){
        persistencia=new SqliteDB("jdbc:sqlite:usuario.db", null, null, "org.sqlite.JDBC");
    }

    /**
     * Metodo para aniadir un alumno a la lista
     * @param alumno a insertar
     * @throws FicheroException controlado
     */
    public void aniadir(Alumno alumno) throws FicheroException{
        persistencia.add(alumno);
    }

    /**
     * Metodo para eliminar un alumno de la lista
     * @param alumno a eliminar
     */
    public void eliminar(Alumno alumno){
        persistencia.remove(alumno);
    }

    /**
     * Metodo que modifica al alumno buscado
     * @param alumno a buscar y modificar
     */
    public void modificar(Alumno alumno){
        if(persistencia.existe(alumno))
            persistencia.actualizar(alumno);
    }

    /**
     * Funcion para buscar y mostrar un usuario
     * @param alumno a buscar
     * @return resultado o no
     */
    public Alumno buscar(String identificador){
        Alumno alumno=null;
        return alumno;
    }
}
