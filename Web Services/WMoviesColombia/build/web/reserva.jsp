<%-- 
    Document   : dashboard
    Created on : 19-nov-2017, 21:39:37
    Author     : MICHAEL
--%>

<%@page import="java.io.PrintWriter"%>
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
    
        <jsp:useBean id="ValidUsuario" scope="session" class="webservices.Usuario" />
        <h1 align="right">| Hola 
            <jsp:getProperty name="ValidUsuario" property="nombre" />
        </h1>
        <h1>Reserva de Peliculas</h1>
        <ul>
            <li><a href="dashboard.jsp">Inicio</a></li>
            <li><a href="reserva.jsp">Reservar</a></li>
        </ul>
        <form action="SReserva" method="POST">
            <c:forEach items="${peliculasDisponibles}" var="pelicula">
                <table border="1">
                    <tr>
                        <td>
                            <input type="radio" name="rdbIdPelicula" value="${pelicula.id}" />
                        </td>
                        <td colspan="2">
                            <h3 align="center">${pelicula.nombre}</h3>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Director</td>
                        <td>${pelicula.director}</td>                        
                    </tr>
                    <tr>
                        <td></td>
                        <td>Duración</td>
                        <td>${pelicula.duracion}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Fecha Estreno</td>
                        <td>${pelicula.fechaEstreno.toString()}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Resumen</td>
                        <td>${pelicula.resumen}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Reservar" name="btnReservar" align="center"/>
                    </td>
                </tr>
            </table>
            <div>
                <%
                    HttpSession sesion= request.getSession();
                    if(sesion.getAttribute("error") != null){   
                        out.println("<label>La pelicula ya se encuentra reservada</label>");
                    }
                %>
            </div>
        </form>
</html>