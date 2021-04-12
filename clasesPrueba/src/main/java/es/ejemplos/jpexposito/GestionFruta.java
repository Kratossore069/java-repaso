package es.ejemplos.jpexposito;

import java.util.ArrayList;

public class GestionFruta extends Fruta {

    ArrayList<Fruta> listaFrutas;

    /**
     * Constructor por defecto
     */
    public GestionFruta() {
        listaFrutas = new ArrayList<>();
    }

    /**
     * Cuantas piezas de fruta existen en la lista
     * @return numero de piezas
     */
    public int inventario(){
        return listaFrutas.size();
    }
    /**
     * Metodo para insertar frutas en la lista
     * @param fruta a insertar
     */
    public void insertar(Fruta fruta) {
        if(fruta!=null){
            listaFrutas.add(fruta);
        }
    }

    /**
     * Funcion que devuelve si existe una fruta o no
     * @param fruta a buscar
     * @return verdadero (existe) o falso (no existe)
     */
    public boolean buscar(Fruta fruta) {
        boolean existeFruta = false;
        if (listaFrutas.contains(fruta)) {
            existeFruta = true;
        }
        return existeFruta;
    }

    /**
     * Funcion que elimina ua fruta de la lista
     * @param fruta a eliminar
     * @return si la elimina o no por true o false
     */
    public boolean eliminar(Fruta fruta) {
        boolean eliminoFruta=false;
        if (buscar(fruta)) {
            listaFrutas.remove(fruta);
            eliminoFruta=true;
        }
        return eliminoFruta;
    }
}