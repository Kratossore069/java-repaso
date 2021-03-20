package es.iesptocruz.victor;

import java.util.ArrayList;

public class Lista {

    ArrayList<String> elementos = null;

    /**
     * Constructor por defecto de la clase
     */
    public Lista() {
        elementos = new ArrayList<>();
    }

    /**
     * Método que inserta un elemento en el arraylist
     * 
     * @param dato elemento a insertar
     */
    public void insertar(String dato) {
        elementos.add(dato);
    }

    /**
     * Función que verifica si la lista contiene el dato
     * 
     * @param dato a encontrar
     * @return respuesta
     */
    public boolean existe(String dato) {
        return elementos.contains(dato);
    }

    /**
     * Método que elimina de una lista una posición
     * 
     * @param lugar posición a eliminar
     */
    public void eliminar(String lugar) {
        elementos.remove(lugar);
    }

    /**
     * Buscar un elemento
     * 
     * @param dato el elemento a buscar
     * @return el elemento si existe
     */
    public String buscar(String dato) {
        int posicion = -1;
        String elemento = null;
        posicion = elementos.indexOf(dato);
        if (posicion != -1) {
            elemento = elementos.get(posicion);
        }
        return elemento;
    }
}
