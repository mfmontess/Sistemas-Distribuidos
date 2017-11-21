/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservices.Usuario;
import webservices.Pelicula;
import webservices.WSPeliculas;
import webservices.WSPeliculas_Service;
import webservices.WSUsuarios;
import webservices.WSUsuarios_Service;

/**
 *
 * @author MICHAEL
 */
@WebServlet(name = "SAutenticacion", urlPatterns = {"/SAutenticacion"})
public class SAutenticacion extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WSMoviesColombia/WSUsuarios.wsdl")
    private WSUsuarios_Service serviceUsuarios;
        
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
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Recuperar los valores que se van a ingresar por el usuario
            String nombre = request.getParameter("txtNombre");
            String contraseña = request.getParameter("txtContraseÃ±a");
            
            Usuario usuario = validar(nombre, contraseña);
         
            if (usuario !=null){
                HttpSession sesion= request.getSession();
                sesion.setAttribute("ValidUsuario", usuario);
                
                List<Pelicula> peliculas = obtenerPeliculas();
                sesion.setAttribute("peliculas", peliculas);
                
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }else{
                response.sendRedirect("index.jsp");
            }
    }
    
    private List<Pelicula> obtenerPeliculas(){
        WSPeliculas port = servicePeliculas.getWSPeliculasPort();
        return port.obtenerPeliculas();
    }
    
    private Usuario validar(java.lang.String nombre, java.lang.String contraseña) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WSUsuarios port = serviceUsuarios.getWSUsuariosPort();
        return port.validar(nombre,contraseña);
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
        processRequest(request, response);
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

}
