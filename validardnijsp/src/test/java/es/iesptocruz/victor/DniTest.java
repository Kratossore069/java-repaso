package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DniTest {

    static RutaModelo rutaModelo;
    Ruta ruta = null;

    @BeforeAll
    public static void beforeAll(){
        if (rutaModelo == null){
            try {
                rutaModelo = new RutaModelo();
            } catch (Exception e) {
                fail("Se ha producido un error en el indicio de la BBDD");
            }

        }
    }

    @BeforeEach
    public void crearRuta() {
        Date diaPateo=new Date();
        ruta =new Ruta("123A", "Victor", diaPateo, 2, 689564512, 6);
        try {
            rutaModelo.insertar(ruta);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error insertando la ruta");
        }
    }

    @AfterEach
    public void eliminarRuta() {
        if (ruta != null) {
            try {
                rutaModelo.eliminar(ruta);
            } catch (PersistenciaException e) {
                fail("Se ha producido un error eliminando la ruta");
            }
        }
    }

    /**
     * Test que busca una cuenta
     */
    @Test
    public void buscarRutaTest() {
        try {
            Ruta rutaEncontrada = rutaModelo.buscar(ruta.getIdentificador());
            assertNotNull(rutaEncontrada, "No se debe de obtener un elemento nulo");
            assertEquals(ruta, rutaEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del la cuenta,e:" + e.getMessage());
        }
    }

    /**
     * Test que actualiza una cuenta
     */
    @Test
    public void actualizarRutaTest() {
        try {
            Ruta rutaEncontrada = rutaModelo.buscar(ruta.getIdentificador());
            assertNotNull(rutaEncontrada, "No se debe de obtener un elemento nulo");
            rutaEncontrada.setNombre("Pepe");
            rutaModelo.actualizar(rutaEncontrada);
            Ruta rutaActualziada = rutaModelo.buscar(rutaEncontrada.getIdentificador());
            assertEquals(rutaActualziada, rutaEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del la cuenta,e:" + e.getMessage());
        }
    }

    /**
     * Test que inserta una nueva cuenta en el registro
     */
    @Test
    public void insertarRutaTest() {
        Date diaPateo=new Date();
        Ruta ruta2 =new Ruta("123B", "Victor", diaPateo, 7, 689564556, 10);
        try {
            rutaModelo.insertar(ruta2);
            Ruta rutaEncontrada = rutaModelo.buscar(ruta2.getIdentificador());
            assertEquals(ruta2, rutaEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del la cuenta,e:" + e.getMessage());
        }finally{
            if(ruta2!=null){
                try {
                    rutaModelo.eliminar(ruta2);
                } catch (PersistenciaException e) {
                    fail("No ha sido posible eliminar la cuenta creada");
                }
            }
        }
    }
}
