package es.iesptocruz.victor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.iesptocruz.victor.controlador.VehiculosController;
import es.iesptocruz.victor.excepciones.VehiculosException;
import es.iesptocruz.victor.modelo.Vehiculos;

/**
 * Unit test for simple App.
 */
public class VehiculosTest {
    
    VehiculosController controlador;
    Vehiculos vehiculo;

    @Before
    public void setUp() throws VehiculosException{
        if(controlador==null){
            controlador=new VehiculosController();
            vehiculo=new Vehiculos("123A", "Ford");
            controlador.insertar(vehiculo);
        }
    }

    @After
    public void setDown() throws VehiculosException{
        controlador.eliminar(vehiculo);
    }

    /**
     * Test que muestra que se aniaden elementos
     */
    @Test
    public void insertarTest(){
        assertEquals("Debe haber un item", 1, controlador.inventario());
    }

    /**
     * Test que elimina un vehiculo
     */
    @Test
    public void eliminarTest(){
        try{
            controlador.eliminar(vehiculo);
            assertEquals("Debe haber 0 item", 0, controlador.inventario());
        }catch(Exception ex){
            fail("Hay mas de un item");
        }
    }

    /**
     * Test que muestra todos los vehiculos registrados
     */
    @Test
    public void mostrarTodoTest(){
        assertEquals("Debe haber un solo registro",
        "[Vehiculos [marca=Ford, matricula=123A]]", controlador.mostrar());
    }

    /**
     * Test que muestra que se validan los vehiculos
     */
    @Test
    public void validarTest(){
        assertEquals("El vehiculo existe", true, controlador.existe(vehiculo));
    }
}
