package es.ejemplos.jpexposito;

import java.util.LinkedList;

public class GestionLinked extends Fruta{
    
    LinkedList<Fruta> listaFrutas;

    /**
     * Constructor por defecto
     */
    public GestionLinked(){
        listaFrutas=new LinkedList<>();
    }

    /**
     * Aniade la posicion en la lista de la fruta
     * @param posicion 0 para el principio y 1 para el final
     * @param fruta fruta a insertar
     */
    public void aniadir(int posicion,Fruta fruta){
        switch(posicion){
            case 0: listaFrutas.addFirst(fruta);
                    break;
            case 1: listaFrutas.addLast(fruta);
                    break;
        }
    }

    /**
     * Elimina la fruta que este en cierta posicion
     * @param posicion 0 para el principio y 1 para el final
     */
    public void eliminar(int posicion){
        switch(posicion){
            case 0: listaFrutas.removeFirst();
                    break;
            case 1: listaFrutas.removeLast();
                    break;
        }
    }

    /**
     * Mostrar por pantalla el primer o la ultima fruta aniadida
     * @param posicion 0 para el principio y 1 para el final
     */
    public void mostrar(int posicion){
        switch(posicion){
            case 0: listaFrutas.getFirst();
                    break;
            case 1: listaFrutas.getLast();
                    break;
        }        
    }

    /**
     * Inventario de las frutas
     * @return numero de frutas en stock
     */
    public int inventarioFrutas(){
        return listaFrutas.size();
    }

}
