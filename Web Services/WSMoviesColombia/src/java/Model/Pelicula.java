/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author MICHAEL
 */
public class Pelicula {
    private int id;
    private EstadoPelicula estado;

    public EstadoPelicula getEstado() {
        return estado;
    }

    public void setEstado(EstadoPelicula estado) {
        this.estado = estado;
    }

    public Pelicula(int id, String nombre, Date fecha_estreno, String resumen, String director, int duracion, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_estreno = fecha_estreno;
        this.resumen = resumen;
        this.director = director;
        this.duracion = duracion;
        this.estado = EstadoPelicula.DISPONIBLE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    private String nombre;
    private Date fecha_estreno;
    private String resumen;
    private String director;
    private int duracion;
}
