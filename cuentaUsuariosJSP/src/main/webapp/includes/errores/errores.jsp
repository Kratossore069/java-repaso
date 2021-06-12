<!DOCTYPE html>
<html lang="en">
<%@ page isErrorPage="true" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control de errores</title>
</head>
<body>
    <h1>Error rescatado de la petición</h1>
    <% exception.printStackTrace(response.getWriter()); %>
    <a href="../../index.jsp">Volver atrás</a>
</body>
</html>