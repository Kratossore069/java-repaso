<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="errores.jsp" %>
<%@ page import="es.iesptocruz.victor.controlador.UsuarioControlador" %>
<%@ page import="es.iesptocruz.victor.api.Usuario" %>
<%@ page import="es.iesptocruz.victor.excepciones.*" %>
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
            try{
                UsuarioControlador userController = new UsuarioControlador();
                Usuario userEncontrado = userController.buscarUsuario("Víctor",dni);
            }catch(Exception exception){
                throw new PersistenciaException(exception.getMessage());
            }
        %>

        <h3>Esto se ha encontrado: <%= userEncontrado.toString() %></h3>

        <%@ include file="pie.jsp"%>
    </body>
</html>