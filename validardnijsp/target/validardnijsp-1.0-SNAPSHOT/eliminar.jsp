<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar un DNI</title>
</head>
<body>
    <%String eliminarDNI=request.getParameter("eliminar");%>
    <h3>Usted quiere eliminar <%= eliminarDNI%></h3>
    <a href="index.jsp">Volver atrás</a>
</body>
</html>