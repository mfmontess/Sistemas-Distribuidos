/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MICHAEL
 */
public class Reserva {
    
    private Pelicula pelicula;
    private int id;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public int getId() {
        return id;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setId(int idReserva) {
        this.id = idReserva;
    }
}
