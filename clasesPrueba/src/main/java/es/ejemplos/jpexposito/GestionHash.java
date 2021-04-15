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
     */
    public void insertarFruta(Fruta fruta){
        listaHash.put(fruta.getIdentificador(),fruta);
    }

    /**
     * Funcion para visualizar la lista de frutas
     * @return una lista en String
     */
    public String mostrarLista(){
        String resultado="";
        for (Integer codigo: listaHash.keySet()) {
            String key = codigo.toString();
            String value = listaHash.get(codigo).toString();
            resultado=key+" "+value;
        }
        return resultado;
    }

    /**
     * Metodo que elimina una fruta por su numero de serie
     * @param numeroSerie numero de la fruta a eliminar
     */
    public void eliminarFruta(int numeroSerie){
        listaHash.remove(numeroSerie);
    }
}
