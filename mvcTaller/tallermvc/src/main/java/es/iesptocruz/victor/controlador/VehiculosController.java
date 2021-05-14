package es.iesptocruz.victor.controlador;

import java.util.ArrayList;

import es.iesptocruz.victor.api.Vehiculo;
import es.iesptocruz.victor.excepciones.FicheroException;
import es.iesptocruz.victor.excepciones.VehiculoException;
import es.iesptocruz.victor.modelo.Fichero;
import es.iesptocruz.victor.modelo.VehiculosModelo;

public class VehiculosController {

    VehiculosModelo vehiculoModelo;

    /**
     * Constructor por defecto
     */
    public VehiculosController(){
        vehiculoModelo=new VehiculosModelo();
    }

    /**
     * Metodo que aniade vehiculos a una lista
     * 
     * @param vehiculo a insertar
     * @throws VehiculoException controlado
     * @throws FicheroException
     */
    public void insertar(Vehiculo vehiculo) throws VehiculoException, FicheroException {
        validar(vehiculo);
        existe(vehiculo)
    }

    /**
     * Metodo que elimina un coche de la lista
     * 
     * @param vehiculo a eliminar
     * @throws VehiculoException controlada
     */
    public void eliminar(Vehiculo vehiculo) throws VehiculoException {
        validar(vehiculo);
        if (existe(vehiculo)){
            lista.remove(vehiculo.toString());
        }
    }

    /**
     * Funcion que muestra en una lista todos los vehiculos
     */
    public String mostrar() {
        return lista.toString();
    }

    /**
     * Funcion que busca un vehiculo por su matricula
     * @param matricula a buscar
     * @return si encuentra o no el vehiculo
     */
    public String mostrar(String matricula) {
        String vehiculoEncontrado="Matricula no encontrada";
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).contains(matricula))
                vehiculoEncontrado=lista.get(i);
        }
        return vehiculoEncontrado;
    }

    /**
     * Funcion que modifica el vehiculo aniadido
     * @param vehiculo a buscar
     * @return modificado o no
     */
    public String modificar(Vehiculo vehiculo){
        return (existe(vehiculo)) ? "Su vehiculo ahora es un tanque":
        "Su vehiculo no se encuentra";
    }

    /**
     * Funcion que valora si el vehiculo existe o no en la lista
     */
    public boolean existe(Vehiculo vehiculo) {
        return (lista.contains(vehiculo.toString())) ? true : false;
    }

    /**
     * Metodo que se encarga de validar los datos introducidos
     * 
     * @param vehiculos es un objeto que debe validar
     * @throws VehiculoException controlado
     */
    public void validar(Vehiculo vehiculos) throws VehiculoException {
        if (vehiculos.getMarca() == null) {
            throw new VehiculoException("La marca no puede estar vacia o nula");
        }
        if (vehiculos.getMatricula() == null) {
            throw new VehiculoException("La matricula no puede estar vacia o nula");
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
