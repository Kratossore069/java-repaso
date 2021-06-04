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
		
		Información recibida<br/>
		<%String dniRecibido=request.getParameter("dni");%>
		<p>DNI : <%= dniRecibido%></p>
		
		
		<%if(validarCuenta.validar(dniRecibido)){%>
            DNI correcto<br/>
        <%}else{%>
            Error con el DNI insertado<br/>
        <%}%>  
		<a href="index.jsp">Volver atrás</a>
	</body>
</html>
