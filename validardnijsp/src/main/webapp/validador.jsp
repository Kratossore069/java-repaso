<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registro del usuario</title>
	</head>
	<body>
		<h1>Verificar detalles</h1>
		<jsp:useBean id="validarCuenta" class="es.iesptocruz.victor.ValidarDni"/>
		<jsp:useBean id="crearBbdd" class="es.iesptocruz.victor.modelo.Bbdd"/>
		
		Información recibida<br/>
		<%String dniRecibido=request.getParameter("dni");%>
		<p>DNI : <%= dniRecibido%></p>

		<% 
			crearBbdd.crear();
		%>
		
		
		<%if(validarCuenta.validar(dniRecibido)){%>
            Correcto<br/>
        <%}else{%>
            Error<br/>
        <%}%>  
		
	</body>
</html>
