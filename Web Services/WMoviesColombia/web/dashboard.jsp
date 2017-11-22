<%-- 
    Document   : dashboard
    Created on : 19-nov-2017, 21:39:37
    Author     : MICHAEL
--%>

<%@page import="java.util.*"%>
<%@page import="webservices.Pelicula"%>
<%@page import="webservices.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
    </head>
    <body>
        <jsp:useBean id="ValidUsuario" scope="session" class="webservices.Usuario" />
        <h1 align="right">| Hola 
            <jsp:getProperty name="ValidUsuario" property="nombre" />
        </h1>
        <h1>Peliculas </h1>
        <ul>
            <li><a href="dashboard.jsp">Inicio</a></li>
            <li><a href="SReserva?consultar=true">Reservar</a></li>
        </ul>
            <c:forEach items="${peliculas}" var="pelicula">
                <table border="1">
                    <tr>
                        <td>Titulo</td>
                        <td>Director</td>
                        <td>Duración</td>
                        <td>Fecha Estreno</td>
                        <td>Resumen</td>
                        <td>Estado</td>
                    </tr>
                    <tr>
                        <td>${pelicula.nombre}</td>
                        <td>${pelicula.director}</td>
                        <td>${pelicula.duracion}</td>
                        <td>${pelicula.fechaEstreno.toString()}</td>
                        <td>${pelicula.resumen}</td>
                        <td>${pelicula.estado}</td>
                    </tr>
                </table>
                </br>
            </c:forEach>
    </body>
</html>