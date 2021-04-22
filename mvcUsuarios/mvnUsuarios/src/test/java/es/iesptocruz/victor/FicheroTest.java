package es.iesptocruz.victor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.iesptocruz.victor.exceptions.FicheroException;
import es.iesptocruz.victor.modelo.UsuarioModelo;

public class FicheroTest {
    UsuarioModelo userModelo;
    String ruta="texto.txt";
    String texto="Hola";

    @Before
    public void setUp() throws FicheroException{
        if(userModelo==null){
            userModelo=new UsuarioModelo();
            userModelo.insertar(ruta, texto);
        }
    }

    @After
    public void setDown() throws FicheroException{
        userModelo.eliminar(ruta);
    }

    /**
     * Test que demuestra que se lee el fichero
     * @throws FicheroException controlado
     */
    @Test
    public void leerTest() throws FicheroException{
        assertEquals("Debe mostrar esa palabra", "Hola", userModelo.leer(ruta));
    }

    /**
     * Test que demuestra que se escribe dentro del fichero exitosamente
     * @throws FicheroException controlado
     */
    @Test
    public void insertarTest() throws FicheroException{
        userModelo.insertar(ruta, "Mundo");
        assertEquals("Debe sobrescribir el archivo", "Mundo", userModelo.leer(ruta));
    }

    /**
     * Test que modifica el contenido del fichero
     * @throws FicheroException controlado
     */
    @Test
    public void modificarTest() throws FicheroException{
        userModelo.modificar(ruta);
        assertEquals("Debe modificar el archivo", "Texto cambiado",
        userModelo.leer(ruta));
    }

    /**
     * Test que demuestra que busca si existe el archivo
     */
    @Test
    public void buscarTest(){
        assertEquals("Debe existir el archivo", true,
        userModelo.buscar(ruta));
    }

    /**
     * Test que demuestra que falla si no existe el archivo
     */
    @Test
    public void noBuscarTest(){
        assertEquals("No debe existir el archivo", false,
        userModelo.buscar("algo.txt"));
    }
}
