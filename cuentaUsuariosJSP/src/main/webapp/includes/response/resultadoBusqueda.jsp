<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="includes/errores/errores.jsp" %>
<%@ page import="es.iesptocruz.victor.controlador.UsuarioControlador" %>
<%@ page import="es.iesptocruz.victor.exception.*" %>
<%@ page import="es.iesptocruz.victor.api.*" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Resultado de la búsqueda</title>
    </head>
    <body>
        <h1>Dni a consultar</h1>
        
        <% String dni=request.getParameter("dni");%>
          
        <p>Dni recogido: <%= dni%></p>

        <%
            Usuario userEncontrado=null;
            try{
                UsuarioControlador userController = new UsuarioControlador();
                userEncontrado = userController.buscarUsuario(dni);
            }catch(Exception exception){
                throw new PersistenciaException("Error encontrado "+exception.getMessage());
            }
            if(userEncontrado==null){
                throw new PersistenciaException("EL USUARIO NO SE ENCUENTRA PORQUE ES NULO");
            }
        %>

        <h4><%= userEncontrado.toString() %></h4>

        <%@ include file="pie.jsp"%>
    </body>
</html>