package es.iesptocruz.victor;

import java.util.ArrayList;

public class Lista {
    
    ArrayList<String> elementos=null;

    /**
     * Constructor por defecto de la clase
     */
    public Lista(){
        elementos=new ArrayList<>();
    }

    /**
     * Método que inserta un elemento en el arraylist
     * @param dato elemento a insertar
     */
    public void insertarDatos(String dato){
        elementos.add(dato);
    }
    /**
     * Función que verifica si la lista contiene el dato
     * @param dato a encontrar
     * @return respuesta
     */
    public boolean existe(String dato){
        return elementos.contains(dato);
    }

    /**
     * Método que elimina de una lista una posición
     * @param lugar posición a eliminar
     */
    public void eliminarElemento(int lugar){
        elementos.remove(lugar);
    }
}
