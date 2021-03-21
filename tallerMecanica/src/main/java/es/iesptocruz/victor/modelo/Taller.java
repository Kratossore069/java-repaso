package es.iesptocruz.victor.modelo;

import java.util.ArrayList;

public class Taller {

    ArrayList<String> coches=null;

    /**
     * Constructor por defecto
     */
    public Taller(){
        coches=new ArrayList<>();
    }

    /**
     * Coches existentes en el taller
     * @return número de coches, si no devuelve nada, no hay ninguno
     */
    public int numeroCoches(){
        return coches.size();
    }

    /**
     * Busca un coche por matrícula
     * @param matricula es un string
     * @return devuelve si existe
     */
    public String buscarCoche(String matricula){
        ArrayList<String> listaMostrar=new ArrayList<>();
        if(coches.contains(matricula)){
            listaMostrar.add(matricula);
        }
        return listaMostrar.toString();
    }

    /**
     * Añadir un coche nuevo por matrícula
     * @param matricula a insertar
     */
    public void aniadirCoche(String matricula){
        coches.add(matricula);
    }

    /**
     * Eliminamos un coche si existe
     * @param matricula insertar
     * @return mensaje de si se ha eliminado o no
     */
    public String eliminarCoche(String matricula){
        String salida="";
        if(coches.contains(matricula)){
            coches.remove(matricula);
            salida="Eliminado "+matricula;
        }else{
            salida="No encontrado";
        }
        return salida;
    }
}
