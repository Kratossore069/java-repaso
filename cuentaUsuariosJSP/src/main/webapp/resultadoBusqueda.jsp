<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="errores.jsp" %>
<%@ page import="es.iesptocruz.victor.controlador.UsuarioControlador" %>
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
          
        <p>Dni a encontrado: <%= dni%></p>

        <% 
        UsuarioControlador userController;
        try{
            userController=new UsuarioControlador();
            userController.connectSqlite();
        }catch(PersistenciaException ex){
            throw new PersistenciaException("Algo no ha salido bien \n"+ex);
        }
        String resultado=null;
        if(userController.validarDNI(dni)){
            resultado="Este DNI es óptimo";
        }else{
            resultado="Este DNI no sirve para trabajar";
        }
        %>
        <h4><%= resultado%></h4>
        <%@ include file="pie.jsp"%>
    </body>
</html>