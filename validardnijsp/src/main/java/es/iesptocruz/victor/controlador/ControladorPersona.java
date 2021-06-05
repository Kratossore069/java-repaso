package es.iesptocruz.victor.controlador;

import es.iesptocruz.victor.excepciones.DniException;
import es.iesptocruz.victor.excepciones.PersistenciaException;
import es.iesptocruz.victor.modelo.PersonaModelo;

public class ControladorPersona {
    PersonaModelo modeloPersona;
    /**
     * Constructor por defecto
     * @throws PersistenciaException controlado
     */
    public ControladorPersona() throws PersistenciaException{
        modeloPersona=new PersonaModelo();
    }

    public String buscar(String dni){
        return modeloPersona.buscar(dni);
    }

    /**
     * Funcion que valida un DNI
     * @param dni a validar
     * @return true or false
     * @throws DniException error
     */
    public boolean validar(String dni) throws DniException{
        verificarDni(dni);
        return modeloPersona.validarDNI(dni);
    }

    /**
     * Metodo que verifica si el DNI esta bien
     * @param dni a valorar
     * @throws DniException controlado
     */
    public void verificarDni(String dni) throws DniException{
        if(dni==null || dni.equals(""))
            throw new DniException("El dni insertado no es valido");
    }
}
