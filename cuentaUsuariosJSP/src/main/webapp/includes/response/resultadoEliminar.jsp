<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="includes/errores/errores.jsp" %>
<%@ page import="es.ejemplos.jpexposito.controlador.UsuarioControlador" %>
<%@ page import="es.ejemplos.jpexposito.exception.*" %>
<%@ page import="es.ejemplos.jpexposito.api.*" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Resultado de eliminar</title>
    </head>
    <body>
        <h1>Dni a consultar</h1>
        
        <% String dni=request.getParameter("dni");%>
          
        <p>Dni recogido: <%= dni%></p>

        <%
            try{
                UsuarioControlador userController = new UsuarioControlador();
                userController.eliminarUsuario(dni);
                out.println("Eliminado con éxito");
            }catch(Exception exception){
                throw new PersistenciaException("Error encontrado "+exception.getMessage());
            }
        %>

        <%@ include file="pie.jsp"%>
    </body>
</html>