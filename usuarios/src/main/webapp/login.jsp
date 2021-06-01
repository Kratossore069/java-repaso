<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de inicio</title>
    </head>

    <body>
        <h1>Detalles del usuario</h1>
        <%-- The form data will be passed to acceptuser.jsp for validation on clicking submit --%>
            <form method="get" action="acceptuser.jsp">
                Nombre usuario : <input type="text" name="user"><br /><br />
                Password del usuario : <input type="password" name="pass"><br />
                <input type="submit" value="Enviar">
            </form>
    </body>

    </html>