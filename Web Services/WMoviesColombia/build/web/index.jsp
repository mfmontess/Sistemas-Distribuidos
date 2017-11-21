<%-- 
    Document   : index
    Created on : 18-nov-2017, 17:03:03
    Author     : MICHAEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SAutenticacion" method="POST">
            <div>
                <label>Nombre: </label>
                <input type="text" name="txtNombre" />
                <label>Contraseña: </label>
                <input type="password" name="txtContraseña" />
                <input type="submit" value="Ingresar" name="btnIngresar" />
            </div>
        </form>
    </body>
</html>
