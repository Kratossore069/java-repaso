<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Resultado de la búsqueda</title>
    </head>
    <body>
        <h1>Dni a consultar</h1>
        <jsp:useBean id="controladorPersona" class="es.iesptocruz.victor.controlador.ControladorPersona"/>
        
        <% String dni=request.getParameter("dni");%>
          
        <p>Dni a encontrado: <%= dni%></p>

        <% 
        String resultado=null;
        if(controladorPersona.verificarDni(dni)){
            resultado="Este DNI es óptimo";
        }else{
            resultado="Este DNI no sirve para trabajar";
        }
        %>
        <h4><%= resultado%></h4>
    </body>
</html>