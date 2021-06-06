<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.iesptocruz.victor.modelo.DdBbSqLite" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registro con JSP</title>
	<%@include file="cabecera.jsp"%>
	</head>
	<body>
		<%--
		DdBbSqLite bbdd=new DdBbSqLite();
		try{
			bbdd.crear();
		}catch(Exception ex){
			out.println(ex);
		}
		--%>
		<%@include file="menu.jsp"%>
		<%@include file="pie.jsp"%>
	</body>
</html>
	
