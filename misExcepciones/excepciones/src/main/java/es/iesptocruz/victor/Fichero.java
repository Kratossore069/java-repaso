package es.iesptocruz.victor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

        if (existe(nombre)) {
            throw new FicheroException("No se puede crear un fichero que ya existe");
        }
        file = new File(nombre);
        try {
            file.createNewFile();
        } catch (IOException exception) {
            throw new FicheroException("Se ha producido un error creando el fichero",
            exception);
        }
    }

    /**
     * Funcion que muestra si se puede leer o no un documento
     * 
     * @param nombre del documento
     * @return true or false
     * @throws FicheroException error controlado
     */
    public boolean sePuedeLeer(String nombre) throws FicheroException {
        File file;
        boolean legible = false;

        if (existe(nombre)) {
            file = new File(nombre);
            legible = file.canRead();
        } else {
            throw new FicheroException("El fichero que intenta leer no existe");
        }
        return legible;
    }

    /**
     * Funcion para leer el documento
     * 
     * @param nombre del documento
     * @return
     * @throws FicheroException
     */
    public String mostrarDocumento(String nombre) throws FicheroException {
        File file;
        String datos = "";

        if (existe(nombre) && sePuedeLeer(nombre)) {
            try {
                file = new File(nombre);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    datos = myReader.nextLine();
                }
                myReader.close();
            } catch (IOException exception) {
                throw new FicheroException("Error al leer el fichero: ", exception);
            }
        } else {
            throw new FicheroException("El fichero que intenta leer no existe");
        }
        return datos;
    }

    /**
     * Funcion que permite saber si el fichero es redactable
     * 
     * @param nombre del fichero
     * @return true or false
     * @throws FicheroException error controlado
     */
    public boolean sePuedeRedactar(String nombre) throws FicheroException {
        File file;
        boolean redactable = false;

        if (existe(nombre)) {
            file = new File(nombre);
            redactable = file.canWrite();
        } else {
            throw new FicheroException("El fichero que intenta escribir no existe");
        }
        return redactable;
    }

    /**
     * Funcion que escribe en un fichero
     * @param nombre del fichero
     * @return mensaje de haber escrito
     * @throws FicheroException error controlado
     */
    public String redactarDocumento(String nombre) throws FicheroException {
        FileWriter fw;
        String datos = "Hola mundo";
        String resultado = "";

        if (existe(nombre) && sePuedeRedactar(nombre)) {
            try {
                fw = new FileWriter(nombre);
                fw.write(datos);
                fw.close();
                resultado = "Escrito con éxito";
            } catch (IOException exception) {
                throw new FicheroException("Error al escribir", exception);
            }
        } else {
            throw new FicheroException("El fichero que intenta escribir no existe");
        }
        return resultado;
    }

    /**
     * Funcion que muestra informacion del fichero
     * @param nombre del fichero
     * @return datos del archivo
     * @throws FicheroException error controlado
     */
    public String datosFichero(String nombre) throws FicheroException{
        File file;
        String datos="";

        if(existe(nombre)){
            file=new File(nombre);
            datos=file.getName()+" "+file.getAbsolutePath();
        }else{
            throw new FicheroException("Error con el fichero deseado");
        }
        return datos;
    }

    /**
     * Funcion que elimina un fichero
     * @param nombre del fichero
     * @return true or false
     * @throws FicheroException error controlado
     */
    public boolean eliminoFichero(String nombre) throws FicheroException { 
        File file;
        boolean eliminado=false;

        if(existe(nombre)){
            file=new File(nombre);
            eliminado=file.delete();
        }else{
            throw new FicheroException("Error al eliminar el fichero");
        } 
        return eliminado;
    } 
}
