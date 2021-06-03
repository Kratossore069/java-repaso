<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registro con JSP</title>
	</head>
	<body>
		<h1>Introduzca su DNI</h1>
		
		<form method ="get" action="validador.jsp">
			DNI del cliente : <input type="text" name="dni"><br/><br/>
			<!-- Enter Password : <input type="password" name ="pass"><br/> -->
				<input type ="submit" value="Validar">	
		</form>
	</body>
</html>
	
