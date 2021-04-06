package es.iesptocruz.victor;

import java.util.ArrayList;

public class Palabras {
    ArrayList<String> lista = null;

    public Palabras() {
        lista = new ArrayList<String>();
    }

    /**
     * Metodo que añade palabras a la lista
     * 
     * @param palabra palabra insertada
     */
    public void insertar(String palabra) {
        lista.add(palabra);
    }

    /**
     * Funcion que cuenta las palabras de la lista
     * 
     * @return numero que representa cuantas palabras hay
     */
    public int numeroPalabras() {
        return lista.size();
    }

    /**
     * Funcion que devuelve el numero de veces que se repite una palabra
     * 
     * @param palabra a buscar
     * @return numero de veces
     */
    public int palabrasIguales(String palabra) {
        int contador = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.contains(palabra)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Funcion que elimina una palabra de la lista
     * 
     * @param palabra a eliminar
     * @return true si existe, false si no
     */
    public boolean eliminar(String palabra) {
        boolean existe = false;
        if (lista.contains(palabra)) {
            lista.remove(palabra);
            existe = true;
        }
        return existe;
    }

    /**
     * Dar la vuelta a la lista original
     * 
     * @return la lista dada la vuelta
     */
    public ArrayList<String> listaReves() {
        ArrayList<String> reves = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
            String elemento = lista.get(lista.size() - 1);
            reves.add(elemento);
        }
        return reves;
    }

    /**
     * Metodo que elimina las palabras repetidas
     */
    public void eliminarRepetidas() {
        for (int i = 0; i < lista.size(); i++) {
            String palabra = lista.get(i);
            for (int j = 0; j < lista.size(); j++) {
                String palabraEvaluar = lista.get(j);
                if (palabra.equals(palabraEvaluar)) {
                    lista.remove(palabraEvaluar);
                }
            }
        }
    }
}
