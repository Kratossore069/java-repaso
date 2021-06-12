<!DOCTYPE html>
<html lang="en">
<%@ page isErrorPage="true" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Control de errores</title>
</head>
<body>
    <h1>Error rescatado de la petición</h1>
    <% exception.printStackTrace(response.getWriter()); %>
    <a href="../../index.jsp">Volver atrás</a>
</body>
</html>