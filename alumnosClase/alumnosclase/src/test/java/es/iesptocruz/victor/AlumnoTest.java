package es.iesptocruz.victor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iesptocruz.victor.api.Alumno;
import es.iesptocruz.victor.controlador.AlumnoController;
import es.iesptocruz.victor.excepciones.FicheroException;
import es.iesptocruz.victor.modelo.AlumnoModelo;

/**
 * Unit test for simple App.
 */
public class AlumnoTest {
    AlumnoController alumnoController;
    AlumnoModelo alumnoModelo;
    Alumno alumno;

    @BeforeEach
    public void setUp() throws FicheroException {
        alumno = new Alumno("Víctor", "Pérez", 1);
        if (alumnoController == null) {
            alumnoController = new AlumnoController();
            alumnoModelo = new AlumnoModelo();
        }
    }

    @Test
    public void aniadirTest() {
        try {
            alumnoModelo.aniadir(alumno);
            assertEquals(1, alumnoModelo.recuento(), "Debe haber un alumno");
        } catch (Exception ex) {
            fail("Algo ha fallado");
        }

    }
}
