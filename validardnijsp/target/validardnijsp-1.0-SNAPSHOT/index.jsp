<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registro con JSP</title>
	</head>
	<body>
		<h1>Introduzca su DNI</h1>
		<!--Consultar la validacion de un DNI-->
		<form method ="post" action="validador.jsp">
			Consultar DNI en la bbdd: <input type="text" name="dni"><br/><br/>			
			<input type ="submit" value="Validar DNI">	
		</form>
		<!--Introducir un DNI en la bbdd-->
		<form method ="post" action="introducir.jsp">
			Introducir DNI en la bbdd: <input type="text" name="insertar"><br/><br/>
			<input type ="submit" value="Ingresar DNI">	
		</form>
		<!--Eliminar un DNI de la bbdd-->
		<form method ="post" action="eliminar.jsp">
			Eliminar DNI en la bbdd: <input type="text" name="eliminar"><br/><br/>
			<input type ="submit" value="Eliminar DNI">	
		</form>
		<!--Actualizar un DNI-->
		<form method ="post" action="actualizar.jsp">
			Actualizar DNI en la bbdd: <input type="text" name="update"><br/><br/>
			<input type ="submit" value="Actualizar DNI">	
		</form>
	</body>
</html>
	
