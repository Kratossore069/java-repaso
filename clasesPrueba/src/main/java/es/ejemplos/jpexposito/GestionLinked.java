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

        if(listaFrutas.isEmpty()){
            return;    
        }
        switch(posicion){
            case 0: listaFrutas.removeFirst();
                    break;
            case 1: listaFrutas.removeLast();
                    break;
        }
    }

    /**
     * Funcion que devuelve el objeto por pantalla si se encuentra
     * @param posicion 0 para el principio y 1 para el final
     * @return el objeto si lo encuentra
     */
    public String mostrar(int posicion){
        String resultado=null;
        switch(posicion){
            case 0: resultado=listaFrutas.getFirst().toString();
                    break;
            case 1: resultado=listaFrutas.getLast().toString();
                    break;
            default: resultado="No existe esa posición";
                    break;
        }        
        return resultado;
    }

    /**
     * Funcion que resuelve el numero de frutas en la lista
     */
    public int inventarioFrutas(){
        return listaFrutas.size();
    }

}
