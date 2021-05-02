package es.iesptocruz.victor.controlador;

import java.util.ArrayList;

import es.iesptocruz.victor.excepciones.FicheroException;
import es.iesptocruz.victor.excepciones.VehiculosException;
import es.iesptocruz.victor.modelo.Fichero;
import es.iesptocruz.victor.modelo.Vehiculos;

public class VehiculosController {

    Vehiculos vehiculos;
    Fichero fichero;
    ArrayList<String> lista;

    /**
     * Constructor por defecto
     * @throws FicheroException
     */
    public VehiculosController() throws FicheroException {
        vehiculos = new Vehiculos();
        fichero=new Fichero();
        fichero.crear("inventarioVehiculos.txt", "Inventario creado");
        lista = new ArrayList<>();
    }

    /**
     * Metodo que aniade vehiculos a una lista
     * 
     * @param vehiculo a insertar
     * @throws VehiculosException controlado
     * @throws FicheroException
     */
    public void insertar(Vehiculos vehiculo) throws VehiculosException, FicheroException {
        validar(vehiculo);
        lista.add(vehiculo.toString());
        fichero.crear("inventarioVehiculos.txt", vehiculo.toString());
    }

    /**
     * Metodo que elimina un coche de la lista
     * 
     * @param vehiculo a eliminar
     * @throws VehiculosException controlada
     */
    public void eliminar(Vehiculos vehiculo) throws VehiculosException {
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
    public String modificar(Vehiculos vehiculo){
        return (existe(vehiculo)) ? "Su vehiculo ahora es un tanque":
        "Su vehiculo no se encuentra";
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
