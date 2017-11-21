/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Model.EstadoPelicula;
import Model.Pelicula;
import Model.PeliculaDAO;
import Model.Reserva;
import Model.ReservaDAO;
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
     * @return Lista de peliculas existentes
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
     * @return Objeto reserva generado
     */
    @WebMethod(operationName = "reservarPelicula")
    public Reserva reservarPelicula(@WebParam(name = "idPelicula")int idPelicula, @WebParam(name = "idUsuario") int idUsuario) {
        PeliculaDAO dbpelicula = new PeliculaDAO();
        Pelicula pelicula = dbpelicula.obtenerPelicula(idPelicula);
        Reserva reserva = null;
        if (pelicula.getEstado() == EstadoPelicula.DISPONIBLE){
            ReservaDAO db = new ReservaDAO();
            int idReserva = db.reservarPelicula(pelicula.getId(), idUsuario);
            reserva= new Reserva();
            reserva.setId(idReserva);
            reserva.setPelicula(pelicula);
            dbpelicula.actualizarEstado(pelicula.getId(),EstadoPelicula.RESERVADA.getId());
        }
        
        return reserva;
    }
}
