package es.iesptocruz.victor;

import java.util.ArrayList;

public class Palabras {
    ArrayList<String> listaPalabras = null;

    public Palabras() {
        listaPalabras = new ArrayList<String>();
    }

    /**
     * Metodo que añade palabras a la lista
     * 
     * @param palabra insertada
     */
    public void insertar(String palabra) {
        listaPalabras.add(palabra);
    }

    /**
     * Funcion que cuenta las palabras de la lista
     * 
     * @return numero que representa cuantas palabras hay
     */
    public int numeroPalabras() {
        return listaPalabras.size();
    }

    /**
     * Funcion que devuelve el numero de veces que se repite una palabra
     * @param palabra a buscar
     * @return numero de veces
     */
    public int palabrasIguales(String palabra) {
        int contador = 0;

        for (int i = 0; i < listaPalabras.size(); i++) {
            if(listaPalabras.contains(palabra)){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Funcion que elimina una palabra de la lista
     * @param palabra a eliminar
     * @return true si existe, false si no
     */
    public boolean eliminar(String palabra){
        boolean existe=false;
        if(listaPalabras.contains(palabra)){
            listaPalabras.remove(palabra);
            existe=true;
        }
        return existe;
    }
}
