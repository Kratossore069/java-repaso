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
     * Metodo que modifica al alumno buscado
     * @param alumno a buscar y modificar
     */
    public void modificar(Alumno alumno){
        if(lista.contains(alumno))
            alumno.setNombre("Cambiado");
    }

    /**
     * Funcion para buscar y mostrar un usuario
     * @param alumno a buscar
     * @return resultado o no
     */
    public String buscar(Alumno alumno){
        String resultado=null;
        for(int i=0; i<lista.size();i++){
            if(lista.contains(alumno))
                resultado=lista.get(i).toString();
        }
        return resultado;
    }

    /**
     * Recuento de los alumnos inscritos
     * @return numero de alumnos
     */
    public int recuento(){
        return lista.size();
    }
}
