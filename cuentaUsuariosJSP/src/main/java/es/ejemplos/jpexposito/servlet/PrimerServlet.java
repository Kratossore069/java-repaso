package es.ejemplos.jpexposito.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.ejemplos.jpexposito.api.Usuario;
import es.ejemplos.jpexposito.controlador.UsuarioControlador;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class PrimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String message = "Hola mundo";
    UsuarioControlador usuarioControlador;

    public PrimerServlet() throws PersistenciaException {
        iniciarControlador();
    }

    private void iniciarControlador() throws PersistenciaException{
        if(usuarioControlador==null){
            usuarioControlador=new UsuarioControlador();
        }
    }

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // Set response content type
      String nombre=request.getParameter("nombre");
      boolean existe=false;
      Usuario usuario=null;
      try {
        usuario=usuarioControlador.buscarUsuario(nombre);
        if(usuario!=null){
            existe=true;
        }
    } catch (PersistenciaException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Reading Checkbox Data";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         String mensaje=null;
        if(existe){
            mensaje="El usuario "+nombre+" existe ";
        }else{
            mensaje="El usuario "+nombre+" no existe ";
        }
      out.println(docType +
         "<html><head><title>"+title+
         "</title></head><body><h1>"+mensaje+
         "</h1></body></html>"
      );
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        // do nothing.
    }
}
