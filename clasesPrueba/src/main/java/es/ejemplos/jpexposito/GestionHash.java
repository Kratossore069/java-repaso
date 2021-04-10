package es.ejemplos.jpexposito;

import java.util.HashMap;

public class GestionHash {
    HashMap<Integer,Fruta> listaHash;

    /**
     * Constructor por defecto
     */
    public GestionHash(){
        listaHash=new HashMap<>();
    }

    /**
     * Inventario de frutas
     * @return numero entero de registros almacenados
     */
    public int inventarioFrutas(){
        return listaHash.size();
    }

    /**
     * Metodo para introducir frutas
     * @param fruta a insertar
     * @param numSerie numero de serie del producto
     */
    public void insertarFrutas(int numSerie,Fruta fruta){
        if(numSerie>99){
            listaHash.put(numSerie, fruta);
        }
    }

    /**
     * Funcion para visualizar la lista de frutas
     * @return una lista en String
     */
    public String mostrarLista(){
        String lista=null;
        for(int i=0;i<listaHash.size();i++){
            lista=listaHash.get(i).toString();
        }
        return lista;
    }

    /**
     * Metodo que elimina una fruta por su numero de serie
     * @param numeroSerie numero de la fruta a eliminar
     */
    public void eliminarFruta(int numeroSerie){
        listaHash.remove(numeroSerie);
    }
}
