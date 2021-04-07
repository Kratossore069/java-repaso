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
     * Metodo que inserta una fruta nueva
     * @param precio precio
     * @param color color
     * @param peso peso
     * @param nombre nombre debe ponerse siempre
     */
    public void insertar(float peso, String color, float precio, String nombre) {
        if(!(nombre==null)){
            listaFrutas.add(new Fruta(peso,color,precio,nombre));
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