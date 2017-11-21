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
    
        <jsp:useBean id="ValidUsuario" scope="session" class="webservices.Usuario" />
        <h1>Reserva de Peliculas, Hola 
            <jsp:getProperty name="ValidUsuario" property="nombre" />
        </h1>
        <form action="SReserva" method="POST">
            <%List<Pelicula> peliculas = (List<Pelicula>)request.getSession().getAttribute("peliculas");
            for (Pelicula pelicula: peliculas){ %>
            <label>Titulo: </label> <%=pelicula.getNombre()%>            
            <br />
            <label>Director: </label> <%=pelicula.getDirector()%>
            <br />
            <label>Duracion: </label> <%=pelicula.getDuracion()%>
            <br />
            <label>Fecha de estreno: </label> <%=pelicula.getFechaEstreno()%>
            <br />
            <label>Resumen: </label> <%=pelicula.getResumen()%>
            <br />
            <input type="submit" text="Reservar" value="<%=pelicula.getId()%>" name="btnReservar"/>
            <br />
            <%}%>
            
        </form>
            
    
</html>