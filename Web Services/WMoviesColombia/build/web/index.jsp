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
        <title>Movies Colombia</title>
    </head>
    <body>        
        <form action="SAutenticacion" method="POST">
            <table border="0" style="margin-left: 28%;">
                <tr>
                    <td>
                        <h1>Inicio de Sesión</h1>
                    </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" />
                    </td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td>
                        <input type="password" name="txtContraseña" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Ingresar" name="btnIngresar" align="center"/>                        
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
