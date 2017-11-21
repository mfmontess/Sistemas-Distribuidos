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
 public enum EstadoPelicula{
     DISPONIBLE(1,"Disponible"),
     RESERVADA(2,"Reservada");
     
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    private EstadoPelicula(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
 }