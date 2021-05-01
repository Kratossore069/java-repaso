package es.iesptocruz.victor.controlador;

import java.util.ArrayList;

import es.iesptocruz.victor.excepciones.VehiculosException;
import es.iesptocruz.victor.modelo.Vehiculos;

public class VehiculosController {

    Vehiculos vehiculos;
    ArrayList<String> lista;

    /**
     * Constructor por defecto
     */
    public VehiculosController() {
        vehiculos = new Vehiculos();
        lista = new ArrayList<>();
    }

    /**
     * Metodo que aniade vehiculos a una lista
     * 
     * @param vehiculo a insertar
     * @throws VehiculosException controlado
     */
    public void insertar(Vehiculos vehiculo) throws VehiculosException {
        validar(vehiculo);
        lista.add(vehiculo.toString());
    }

    /**
     * Metodo que elimina un coche de la lista
     * 
     * @param vehiculo a eliminar
     * @throws VehiculosException controlada
     */
    public void eliminar(Vehiculos vehiculo) throws VehiculosException {
        validar(vehiculo);
        if (existe(vehiculo))
            lista.remove(vehiculo.toString());
    }

    /**
     * Funcion que muestra en una lista todos los vehiculos
     */
    public String mostrar() {
        return lista.toString();
    }

    /**
     * Funcion que muestra un vehiculo a partir de una matricula
     * @param matricula a buscar
     * @return vehiculo en formato String
     */
    public String mostrar(String matricula) {
        // No sé cómo mostrar un solo objeto a partir de la matricula
        return "";
    }

    /**
     * Funcion que valora si el vehiculo existe o no en la lista
     */
    public boolean existe(Vehiculos vehiculo) {
        return (lista.contains(vehiculo.toString())) ? true : false;
    }

    /**
     * Metodo que se encarga de validar los datos introducidos
     * 
     * @param vehiculos es un objeto que debe validar
     * @throws VehiculosException controlado
     */
    public void validar(Vehiculos vehiculos) throws VehiculosException {
        if (vehiculos.getMarca() == null) {
            throw new VehiculosException("La marca no puede estar vacia o nula");
        }
        if (vehiculos.getMatricula() == null) {
            throw new VehiculosException("La matricula no puede estar vacia o nula");
        }
    }

    /**
     * Funcion que retorna el numero de items de la lista
     * @return numero de items en la lista
     */
    public int inventario(){
        return lista.size();
    }
}
