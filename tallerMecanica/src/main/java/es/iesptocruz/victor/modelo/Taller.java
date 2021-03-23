package es.iesptocruz.victor.modelo;

import java.util.ArrayList;

public class Taller {

    ArrayList<String> matriculas;

    /**
     * Constructor por defecto
     */
    public Taller(){
        matriculas=new ArrayList<>();
    }

    /**
     * matriculas existentes en el taller
     * @return número de matriculas, si no devuelve nada, no hay ninguno
     */
    public int tamanioCoches(){
        return matriculas.size();
    }

    /**
     * Busca un coche por matrícula
     * @param matricula es un string
     * @return devuelve si existe
     */
    public boolean existeCoche(String matricula){
        return matriculas.contains(matricula);
    }

    /**
     * Añadir un coche nuevo por matrícula
     * @param matricula a insertar
     */
    public void aniadirCoche(String matricula){
        matriculas.add(matricula);
    }

    /**
     * Eliminamos un coche si existe
     * @param matricula insertar
     * @return mensaje de si se ha eliminado o no
     */
    public String eliminarCoche(String matricula){
        String salida="Elemento no eliminado";
        if(matriculas.remove(matricula)){
            salida="Elemento eliminado";
        }
        return salida;
    }

    /**
     * Buscar una matrícula
     * @param matricula a buscar
     * @return matricula encontrada, si se encuentra
     */
    public String buscarMatricula(String matricula){
        String matriculaEncontrada=null;
        if(matriculas.contains(matricula)){
            matriculaEncontrada=matricula;
        }
        return matriculaEncontrada;
    }
}
