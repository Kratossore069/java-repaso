package es.iesptocruz.victor.modelo;

import java.io.File;

import es.iesptocruz.victor.exceptions.FicheroException;

public class UsuarioModelo {
   Fichero fichero;

   public UsuarioModelo() {
      fichero = new Fichero();
   }

   /**
    * Metodo que crea un archivo o lo reemplaza y escribe sobre el mismo
    * 
    * @param ruta  del archivo con su nombre
    * @param texto a insertar en el archivo
    * @throws FicheroException error controlado
    */
   public void insertar(String ruta, String texto) throws FicheroException {
      fichero.crear(ruta, texto);
   }

   /**
    * Metodo para eliminar un archivo
    * 
    * @param nombreFichero a eliminar
    * @throws FicheroException error controlado
    */
   public void eliminar(String nombreFichero) throws FicheroException {
      fichero.eliminar(nombreFichero);
   }

   /**
    * Funcion que busca si existe o no un archivo
    * @param rutaFichero a buscar
    * @return true or false
    */
   public boolean buscar(String rutaFichero) {
      File file;
      boolean ficheroExiste = false;
      file = new File(rutaFichero);
      ficheroExiste = file.exists();
      return ficheroExiste;
   }

   /**
    * Metodo que modifica el texto insertado
    * 
    * @param rutaFichero donde modificar
    * @throws FicheroException controlado
    */
   public void modificar(String rutaFichero) throws FicheroException {
      String modificacion = "Texto cambiado";
      fichero.crear(rutaFichero, modificacion);
   }

   /**
    * Funcion que lee un fichero
    * 
    * @param rutaFichero del que leer algo
    * @throws FicheroException error controlado
    */
   public String leer(String rutaFichero) throws FicheroException {
      return fichero.leer(rutaFichero);
   }
}
