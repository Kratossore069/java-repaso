package es.iesptocruz.victor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
    /**
     * Funcion que devuelve si se ha creado o no un fichero nuevo
     * 
     * @param destino en el que se crea el archivo
     * @return si se ha creado o no el archivo
     */
    public String crearArchivo(String destino) {
        String respuesta = null;
        try {
            File myObj = new File(destino);
            if (myObj.createNewFile()) {
                respuesta = "File created: " + myObj.getName();
            } else {
                respuesta = "File already exists.";
            }
        } catch (IOException e) {
            respuesta = "An error occurred.";
            e.printStackTrace();
        }
        return respuesta;
    }

    /**
     * Funcion que escribe en un documento
     * @param destino en el que escribir el fichero
     * @return si se ha escrito o no en el fichero
     */
    public String escriboFichero(String destino) {
        String salida = null;
        try {
          if(destino!=null){
            FileWriter myWriter = new FileWriter(destino);
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            salida = "Successfully wrote to the file.";
          }
        } catch (IOException e) {
            salida = "An error occurred.";
            e.printStackTrace();
        }
        return salida;
    }

    /**
     * Funcion que lee el archivo entero
     * @param destino en el que leer algo
     * @return la informacion de esa lectura
     */
    public String leerDocumento(String destino) {
        String lectura=null;
        try {
          File myObj = new File(destino);
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            lectura = myReader.nextLine();
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          lectura="An error occurred.";
          e.printStackTrace();
        }
        return lectura;
      }

      /**
       * Funcion que elimina un archivo
       * @param destino donde eliminar
       * @return mensaje de eliminado
       */
      public String eliminoArchivo(String destino) { 
        String salida=null;
        File myObj = new File(destino); 
        if (myObj.delete()) { 
          salida="Deleted the file: " + myObj.getName();
        } else {
          salida="Failed to delete the file.";
        }
        return salida; 
      } 
}
