package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.controlador.AlumnoController;
import es.iesptocruz.victor.excepciones.AlumnoException;
import es.iesptocruz.victor.excepciones.FicheroException;

/**
 * Unit test for simple App.
 */
public class AlumnoTest {
    AlumnoController alumnoController;
    Alumno alumno;
    String esperado="Alumno [apellido=Pérez, nombre=Cambiado, numero=1]";

    @BeforeEach
    public void setUp() throws FicheroException, AlumnoException {
        alumno = new Alumno("Víctor", "Pérez", 1);
        if (alumnoController == null) {
            alumnoController = new AlumnoController();
            alumnoController.aniadirAlumno(alumno);
        }
    }

    /**
     * Test que demuestra que se aniaden bien los alumnos a la lista
     */
    @Test
    public void aniadirTest() {
        try {
            assertEquals(1, alumnoController.numeroAlumno(), "Debe haber un alumno");
        } catch (Exception ex) {
            fail("Algo ha fallado");
        }
    }

    /**
     * Test que muestr que se elimina correctamente
     */
    @Test
    public void eliminarTest() {
        try {
            alumnoController.eliminarAlumno(alumno);
            assertEquals(0, alumnoController.numeroAlumno(), "No debe haber alumnos");
        } catch (Exception ex) {
            fail("Algo ha fallado");
        }
    }

    /**
     * Test que demuestra que se modifica y se buscan los alumnos
     */
    @Test
    public void modificarTest() {
        try {
            alumnoController.modificarAlumno(alumno);
            assertEquals(esperado, alumnoController.buscarAlumno(alumno),
            "No debe haber alumnos");
        } catch (Exception ex) {
            fail("Algo ha fallado");
        }
    }

    /**
     * Test que muestra que listar los alumnos funciona
     */
    public void listarTest() {
        assertEquals(esperado, alumnoController.listaAlumno(),"Debe salir la lista");
    }
}
