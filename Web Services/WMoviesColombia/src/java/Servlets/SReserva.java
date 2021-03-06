/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservices.EstadoPelicula;
import webservices.Pelicula;
import webservices.Reserva;
import webservices.Usuario;
import webservices.WSPeliculas;
import webservices.WSPeliculas_Service;

/**
 *
 * @author MICHAEL
 */
@WebServlet(name = "SReserva", urlPatterns = {"/SReserva"})
public class SReserva extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WSMoviesColombia/WSPeliculas.wsdl")
    private WSPeliculas_Service servicePeliculas;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idPelicula = Integer.parseInt(request.getParameter("rdbIdPelicula"));
        int idUsuario = ((Usuario)request.getSession().getAttribute("ValidUsuario")).getId();
        
        WSPeliculas port = servicePeliculas.getWSPeliculasPort();
        Reserva reserva = port.reservarPelicula(idPelicula, idUsuario);
                
        HttpSession sesion= request.getSession();
        
        if (reserva != null){
            List<Pelicula> peliculas = obtenerPeliculas(null);
            sesion.setAttribute("peliculas", peliculas);

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            sesion.setAttribute("error", "La pelicula ya se encuentra reservada");
            request.getRequestDispatcher("reserva.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String consultar = request.getParameter("consultar");
        if ("true".equals(consultar)) {
            load(request);
            request.getRequestDispatcher("reserva.jsp").forward(request, response);
        } else {
            processRequest(request, response);
        }
    }
    
    private void load(HttpServletRequest request){
        HttpSession sesion= request.getSession();
        List<Pelicula> peliculas = obtenerPeliculas(EstadoPelicula.DISPONIBLE);
        sesion.setAttribute("peliculasDisponibles", peliculas);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<Pelicula> obtenerPeliculas(EstadoPelicula estado) {
        WSPeliculas port = servicePeliculas.getWSPeliculasPort();
        return port.obtenerPeliculas(estado);
    }
}