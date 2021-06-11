<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="includes/errores/errores.jsp" %>
<%@ page import="es.iesptocruz.victor.controlador.UsuarioControlador" %>
<%@ page import="es.iesptocruz.victor.exception.*" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Resultado de actualizar</title>
    </head>
    <body>
        <h1>Dni a actualizar</h1>
        
        <% String dni=request.getParameter("dni");%>
          
        <p>Dni recogido: <%= dni%></p>

        <%
            try{
                UsuarioControlador controller=new UsuarioControlador();
                controller.actualizaUsuario(dni);
                out.println("Cambiado con éxito");
            }catch(Exception exception){
                throw new Exception("ERROR AL ACTUALIZAR EL DNI, REVISE SU DNI INSERTADO");
            }
        %>

        <%@ include file="pie.jsp"%>
    </body>
</html>