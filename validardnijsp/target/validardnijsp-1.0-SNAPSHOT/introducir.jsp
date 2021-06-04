<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar un DNI</title>
</head>
<body>
    <%String ingresarDNI=request.getParameter("insertar");%>
    <h3>Usted quiere insertar <%= ingresarDNI%></h3>

    <jsp:useBean id="validarCuenta" class="es.iesptocruz.victor.modelo.ValidarDni"/>
		
		<%if(validarCuenta.validar(ingresarDNI)){%>
            DNI correcto para ingresar<br/>
        <%}else{%>
            Este DNI no es correcto<br/>
        <%}%>  
    <a href="index.jsp">Volver atrás</a>
</body>
</html>