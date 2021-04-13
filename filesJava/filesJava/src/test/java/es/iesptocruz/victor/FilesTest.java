package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilesTest {

    Files files;

    @Before
    public void setUp() {
        if (files == null) {
            files = new Files();
        }
    }

    @After
    public void setDown() {
        files.eliminoArchivo("filename.txt");
    }

    /**
     * Test para crear un archivo nuevo
     */
    @Test
    public void crearTest() {
        assertEquals("File created: filename.txt", files.crearArchivo("filename.txt"));
    }

    /**
     * Test para observar que no se crea un archivo nuevo si ya existe
     */
    @Test
    public void noCrearTest() {
        crearTest();
        assertEquals("File already exists.", files.crearArchivo("filename.txt"));
    }

    /**
     * Test que escribe algo en un archivo
     */
    @Test
    public void escribirTest() {
        assertEquals("Successfully wrote to the file.",
        files.escriboFichero("filename.txt"));
    }

    /**
     * Test que demuestra que no se escribe algo que
     * no se pasa bien por parametro
     */
    @Test
    public void noEscribirTest() {
        assertEquals(null,
        files.escriboFichero(null));
    }

    /**
     * Test que demuestra que se lee el documento
     */
    @Test
    public void leerTest(){
        escribirTest();
        assertEquals("Files in Java might be tricky, but it is fun enough!",
        files.leerDocumento("filename.txt"));
    }

    /**
     * Test que salta un error cuando no puede leer un documento
     */
    @Test
    public void noLeerTest(){
        eliminarTest();
        assertEquals("An error occurred.",
        files.leerDocumento("filename.txt"));
    }

    /**
     * Test que demuestra que se eliminan documentos
     */
    @Test
    public void eliminarTest(){
        files.crearArchivo("filename.txt");
        assertEquals("Deleted the file: filename.txt",
        files.eliminoArchivo("filename.txt"));
    }

    /**
     * Test que muestra que se elimina un documento,
     * este documento ya se ha eliminado antes
     */
    @Test
    public void noEliminarTest(){
        assertEquals("Failed to delete the file.",
        files.eliminoArchivo("filename.txt"));
    }
}
