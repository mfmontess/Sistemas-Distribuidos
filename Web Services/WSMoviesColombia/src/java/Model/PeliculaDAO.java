/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MICHAEL
 */
public class PeliculaDAO {

    public List<Pelicula> obtenerPeliculas() {
        ArrayList<Pelicula> peliculas= new ArrayList<>();
        Connection accessBD = Conexion.getConexion();
        try{
            PreparedStatement ps = accessBD.prepareCall("select pelicula_id, titulo, fecha_estreno,resumen,director,duracion_minutos, estado_pelicula_id\n" +
                "from db_movies_colombia.peliculas");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                peliculas.add(new Pelicula(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getDate(3)
                        ,rs.getString(4)
                        , rs.getString(5)
                        , rs.getInt(6)
                        , rs.getInt(7)
                ));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return peliculas;
    }

    public Pelicula obtenerPelicula(int id) {
        Pelicula pelicula= null;
        Connection accessBD = Conexion.getConexion();
        try{
            PreparedStatement ps = accessBD.prepareCall("select pelicula_id, titulo, fecha_estreno,resumen,director,duracion_minutos, estado_pelicula_id\n" +
                "from db_movies_colombia.peliculas where pelicula_id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pelicula = new Pelicula(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getDate(3)
                        ,rs.getString(4)
                        , rs.getString(5)
                        , rs.getInt(6)
                        , rs.getInt(7)
                );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return pelicula;
    }

    public void actualizarEstado(int idPelicula, int idEstado) {
        Connection accessBD = Conexion.getConexion();
        try{
            PreparedStatement ps = accessBD.prepareCall("update peliculas set estado_pelicula_id=? where pelicula_id=?");
            ps.setInt(1, idEstado);
            ps.setInt(2, idPelicula);
            ps.executeUpdate();
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
