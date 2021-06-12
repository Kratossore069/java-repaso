package es.iesptocruz.victor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iesptocruz.victor.controlador.UsuarioControlador;
import es.iesptocruz.victor.exception.PersistenciaException;

public class ServletActualizar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UsuarioControlador usuarioControlador;

    /**
     * Constructor por defecto
     * 
     * @throws PersistenciaException controlado
     */
    public ServletActualizar() throws PersistenciaException {
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
        String mensaje = null;

        try {
            UsuarioControlador controller = new UsuarioControlador();
            controller.actualizaUsuario(dniRecibido);
            mensaje="Actualizado con éxito";
        } catch (PersistenciaException exception) {
            mensaje="ERROR AL ACTUALIZAR EL DNI "+dniRecibido;
        }

        response.setContentType("text/html");
        String title = "Actualizar dni insertado";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType + "<html><head><title>" + title + "</title></head><body><h1>" + mensaje
                + "</h1><a href='../../index.jsp'>Volver al index</a>"+
                "</body>"+
                "</html>");
    }

    /**
     * Metodo POST del servlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
