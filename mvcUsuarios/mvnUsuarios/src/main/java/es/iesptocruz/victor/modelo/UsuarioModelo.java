package es.iesptocruz.victor.modelo;

import es.iesptocruz.victor.exceptions.FicheroException;

public class UsuarioModelo {
    Fichero fichero;

    public UsuarioModelo() {
        fichero = new Fichero();
    }

    /**
     * Metodo que crea un archivo o lo reemplaza y escribe sobre el mismo
     * @param ruta del archivo con su nombre
     * @param texto a insertar en el archivo
     * @throws FicheroException error controlado
     */
    public void insertar(String ruta, String texto) throws FicheroException {
        fichero.crear(ruta, texto);
     }
  
     /**
      * Metodo para eliminar un archivo
      * @param nombreFichero a eliminar
      * @throws FicheroException error controlado
      */
     public void eliminar(String nombreFichero) throws FicheroException {
        fichero.eliminar(nombreFichero);
     }
  
     public Fichero buscar(String identificador) {
       fichero = null;
  
       return fichero;
     }
  
     public void modificar(Fichero fichero) {
        //lo que sea
     }

     /**
      * Funcion que lee un fichero
      * @param rutaFichero del que leer algo
      * @throws FicheroException error controlado
      */
     public String leer(String rutaFichero) throws FicheroException{
      return fichero.leer(rutaFichero);
     }
}
