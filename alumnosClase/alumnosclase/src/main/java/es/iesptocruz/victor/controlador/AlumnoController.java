package es.iesptocruz.victor.controlador;

import java.util.ArrayList;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.excepciones.AlumnoException;
import es.iesptocruz.victor.excepciones.FicheroException;
import es.iesptocruz.victor.excepciones.PersistenciaException;
import es.iesptocruz.victor.modelo.AlumnoModelo;

public class AlumnoController {

    AlumnoModelo alumnoModelo;

    /**
     * Controlador por defecto
     * 
     * @throws FicheroException controlado
     */
    public AlumnoController() throws FicheroException {
        alumnoModelo = new AlumnoModelo();
    }

    /**
     * Metodo para aniadir un alumno a la lista
     * @param alumno a insertar
     * @throws AlumnoException controlado
     * @throws FicheroException controlado
     */
    public void aniadirAlumno(Alumno alumno) throws AlumnoException, FicheroException {
        validar(alumno);
        alumnoModelo.aniadir(alumno);
    }

    /**
     * Metodo para eliminar de la lista a un alumno
     * @param alumno a eliminar
     * @throws AlumnoException controlado
     */
    public void eliminarAlumno(Alumno alumno) throws AlumnoException{
        validar(alumno);
        alumnoModelo.eliminar(alumno);
    }

    /**
     * Metodo para modificar a un alumno
     * @param alumno a modificar
     * @throws AlumnoException controlado
     */
    public void modificarAlumno(Alumno alumno) throws AlumnoException{
        validar(alumno);
        alumnoModelo.modificar(alumno);
    }

    /**
     * Funcion que busca un alumno
     * @param alumno a buscar
     * @return datos o no del alumno
     * @throws AlumnoException controlado
     * @throws PersistenciaException
     */
    public ArrayList<Alumno> buscarAlumno(Alumno alumno) throws AlumnoException, PersistenciaException{
        validar(alumno);
        return alumnoModelo.buscar(alumno.getNombre());
    }

    /**
     * Funcion que muestra todos los alumnos
     * @return lista completa de alumnos
     */
    public String listaAlumno(){
        return alumnoModelo.listarTodo();
    }

    /**
     * Funcion que lista cuantos alumnos estan registrados
     * @return numero de alumnos en lista
     */
    public int numeroAlumno(){
        return alumnoModelo.recuento();
    }

    /**
     * Funcion que valida si se insertan bien los datos
     * 
     * @param alumno a manipular
     * @return verificacion de los datos
     * @throws AlumnoException controlado
     */
    public String validar(Alumno alumno) throws AlumnoException {
        String respuesta = "";
        if (alumno.getNombre() == "" | alumno.getNombre() == null) {
            respuesta = "El nombre no puede estar vacio o nulo";
        }
        if (alumno.getApellido() == "" | alumno.getApellido() == null) {
            respuesta += "El apellido no puede estar vacio o nulo";
        }
        if (alumno.getNombre() == null | alumno.getNumero() == 0) {
            respuesta += "El numero no puede ser nulo o estar vacio";
        }
        if (!respuesta.isEmpty()) {
            throw new AlumnoException(respuesta);
        }
        return respuesta;
    }

    // public void existeAlumno(Alumno alumno){
    //     if(fichero.co)

    // }
}
