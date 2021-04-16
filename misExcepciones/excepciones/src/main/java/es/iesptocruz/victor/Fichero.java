package es.iesptocruz.victor;

import java.io.File;
import java.io.IOException;

import excepciones.FicheroException;

public class Fichero {

    /**
     * Funcion encargada de verificar si un fichero existe
     * 
     * @param nombreFichero nombre del fichero
     * @return true or false
     */
    public boolean existe(String nombreFichero) {
        File file;
        boolean existeFichero = false;

        file = new File(nombreFichero);
        existeFichero = file.exists();
        return existeFichero;
    }

    /**
     * Metodo que crea un fichero
     * 
     * @param nombre del fichero
     * @throws FicheroException error controlado
     */
    public void crearFichero(String nombre) throws FicheroException {
        File file;
        if (!existe(nombre)) { //Lío de llaves
            file = new File(nombre);
        try {
                file.createNewFile();
            
        } catch (IOException exception) {
            throw new FicheroException("Error al crear el fichero",exception);
        }

    /**
         * Metodo encargado de borrar fichero
         * @param nombre del fichero
         * @throws FicheroException error controlado
         */
    public void borrarFichero(String nombre) throws FicheroException {
            File file;
            if (!existe(nombre)) { //Lío de llaves
                file = new File(nombre);
            try {
                    file.createNewFile();
                
            } catch (IOException exception) {
                throw new FicheroException("Error al crear el fichero",exception);
            }

            // public void crearFichero2(String nombre) throws FicheroException {
            //     File file;
          
            //     if (existe(nombre)) {
            //        throw new FicheroException("No se puede crear un fichero que ya existe");
            //     }
            //     file = new File(nombre);
            //     try {
            //        file.createNewFile();
            //     } catch (IOException exception) {
            //        throw new FicheroException("Se ha producido un error creando el fichero", exception);
            //     }
            //  }
