<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="../errores/errores.jsp" %>
<%@ page import="es.iesptocruz.victor.controlador.UsuarioControlador" %>
<%@ page import="es.iesptocruz.victor.exception.*" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Resultado de AGREGAR</title>
    </head>
    <body>
        <h1>Dni a agregar</h1>
        
        <% String dni=request.getParameter("dni");%>
          
        <p>Dni recogido: <%= dni%></p>

        <%
            try{
                UsuarioControlador controller=new UsuarioControlador();
                controller.aniadirUsuario(dni);
                out.println("Añadido con éxito");
            }catch(Exception exception){
                throw new Exception("ERROR AL AÑADIR EL DNI, REVISE SU DNI INSERTADO");
            }
        %>

        <%@ include file="/assets/pie.jsp"%>
    </body>
</html>