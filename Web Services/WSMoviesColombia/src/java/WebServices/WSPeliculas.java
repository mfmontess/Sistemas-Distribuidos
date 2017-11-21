/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Model.*;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author MICHAEL
 */
@WebService(serviceName = "WSPeliculas")
public class WSPeliculas {

    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "obtenerPeliculas")
    public List<Pelicula> obtenerPeliculas() {
        PeliculaDAO db = new PeliculaDAO();
        List<Pelicula> peliculas = db.obtenerPeliculas();
        return peliculas;
    }
    
    /**
     * Metodo en el cual se reserva una pelicula para un usuario
     * @param idPelicula Id de la pelicula a reservar
     * @param idUsuario Id del usuario que esta reservando
     */
    @WebMethod(operationName = "reservarPelicula")
    public void reservarPelicula(int idPelicula, int idUsuario) {
        PeliculaDAO dbpelicula = new PeliculaDAO();
        Pelicula pelicula = dbpelicula.obtenerPelicula(idPelicula);
        Reserva reserva = null;
        if (pelicula.getEstado() == EstadoPelicula.DISPONIBLE){
            ReservaDAO db = new ReservaDAO();
            db.reservarPelicula(pelicula.getId(), idUsuario);            
            
            dbpelicula.actualizarEstado(pelicula.getId(),EstadoPelicula.RESERVADA.getId());
        }
    }
}
