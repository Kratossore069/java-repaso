package es.iesptocruz.victor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.controlador.UsuarioControlador;
import es.iesptocruz.victor.exception.PersistenciaException;

public class ServletValidarDni extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UsuarioControlador usuarioControlador;

    /**
     * Constructor por defecto
     * 
     * @throws PersistenciaException controlado
     */
    public ServletValidarDni() throws PersistenciaException {
        iniciarControlador();
    }

    /**
     * Metodo que inicializa el controlador en el servlet
     * 
     * @throws PersistenciaException controlado
     */
    private void iniciarControlador() throws PersistenciaException {
        if (usuarioControlador == null) {
            usuarioControlador = new UsuarioControlador();
        }
    }

    /**
     * Metodo GET del servlet
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String dniRecibido = request.getParameter("dni");
        boolean dniValido=false;
        try {
            dniValido = usuarioControlador.validarDniInsertado(dniRecibido);
        } catch (PersistenciaException e) {
            out.println("ERROR AL VALIDAR DNI "+e.getMessage());
        }

        response.setContentType("text/html");
        String title = "Validar dni insertado";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        String mensaje = null;
        if (dniValido) {
            mensaje = "El usuario con dni " + dniRecibido + " es válido ";
        } else {
            mensaje = "El usuario con dni " + dniRecibido + " no es válido ";
        }
        out.println(docType + "<html><head><title>" + title + "</title></head><body><h1>" + mensaje
                + "</h1></body></html>");
    }

    /**
     * Metodo POST del servlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
