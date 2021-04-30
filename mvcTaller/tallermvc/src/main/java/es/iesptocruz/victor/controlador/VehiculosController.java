package es.iesptocruz.victor.controlador;

import java.util.ArrayList;

import es.iesptocruz.victor.excepciones.VehiculosException;
import es.iesptocruz.victor.modelo.Vehiculos;

public class VehiculosController {
    
    Vehiculos vehiculos;
    ArrayList<Vehiculos> lista;

    /**
     * Constructor por defecto
     */
    public VehiculosController(){
        vehiculos=new Vehiculos();
        lista=new ArrayList<>();
    }

    /**
     * Metodo que aniade vehiculos a una lista
     * @param vehiculo a insertar
     * @throws VehiculosException controlado
     */
    public void insertar(Vehiculos vehiculo) throws VehiculosException{
        validar(vehiculo);
        lista.add(vehiculo);
    }

    /**
     * Metodo que se encarga de validar los datos introducidos
     * @param vehiculos es un objeto que debe validar
     * @throws VehiculosException controlado
     */
    public void validar(Vehiculos vehiculos) throws VehiculosException{
        if(vehiculos.getMarca()==null){
            throw new VehiculosException("La marca no puede estar vacia o nula");
        }
        if(vehiculos.getMatricula()==null){
            throw new VehiculosException("La matricula no puede estar vacia o nula");
        }
    }
}
