package es.iesptocruz.victor.modelo;

import java.util.ArrayList;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.excepciones.FicheroException;

public class AlumnoModelo {

    ArrayList<Alumno> lista;
    Fichero fichero;
    private String destino="listaAlumnos.txt";

    /**
     * Constructor por defecto
     * @throws FicheroException controlado
     */
    public AlumnoModelo() throws FicheroException{
        lista=new ArrayList<>();
        fichero=new Fichero();
        fichero.crear(destino, "");
    }

    /**
     * Metodo para aniadir un alumno a la lista
     * @param alumno a insertar
     * @throws FicheroException controlado
     */
    public void aniadir(Alumno alumno) throws FicheroException{
        lista.add(alumno);
        fichero.crear(destino, alumno.toString());
    }

    /**
     * Metodo para eliminar un alumno de la lista
     * @param alumno a eliminar
     */
    public void eliminar(Alumno alumno){
        lista.remove(alumno);
    }

    /**
     * Recuento de los alumnos inscritos
     * @return numero de alumnos
     */
    public int recuento(){
        return lista.size();
    }
}
