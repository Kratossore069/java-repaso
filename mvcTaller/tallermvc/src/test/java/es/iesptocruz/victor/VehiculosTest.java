package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.controlador.VehiculosController;
import es.iesptocruz.victor.excepciones.VehiculosException;
import es.iesptocruz.victor.modelo.Vehiculos;

/**
 * Unit test for simple App.
 */
public class VehiculosTest {
    
    VehiculosController controlador;
    Vehiculos vehiculo;

    @BeforeEach
    public void setUp() throws VehiculosException{
        if(controlador==null){
            controlador=new VehiculosController();
            vehiculo=new Vehiculos("123A", "Ford");
            controlador.insertar(vehiculo);
        }
    }

    @AfterEach
    public void setDown() throws VehiculosException{
        controlador.eliminar(vehiculo);
    }

    /**
     * Test que muestra que se aniaden elementos
     */
    @Test
    public void insertarTest(){
        assertEquals(1, controlador.inventario(),"Debe haber un item");
    }

    /**
     * Test que elimina un vehiculo
     */
    @Test
    public void eliminarTest(){
        try{
            controlador.eliminar(vehiculo);
            assertEquals(0, controlador.inventario(),"Debe haber 0 item");
        }catch(Exception ex){
            fail("Hay mas de un item");
        }
    }

    /**
     * Test que muestra todos los vehiculos registrados
     */
    @Test
    public void mostrarTodoTest(){
        assertEquals("[Vehiculos [marca=Ford, matricula=123A]]",
        controlador.mostrar(),"Debe haber un solo registro");
    }

    /**
     * Test que muestra que se validan los vehiculos
     */
    @Test
    public void validarTest(){
        assertEquals(true, controlador.existe(vehiculo),"El vehiculo existe");
    }
}
