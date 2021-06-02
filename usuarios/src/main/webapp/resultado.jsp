<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
</head>

<body>
    <% String nombre=request.getParameter("user");
       String password=request.getParameter("pass");
       if(nombre=="admin" && password=="admin" ){
            out.println("Bienvenido admin");
       }else{
            out.println("No está autorizado"); 
        }
    %>
            <h1>Usted es: <%= nombre%>
            </h1>
            <h1>Su contrasenia es: <%= password%>
            </h1>
</body>

</html>