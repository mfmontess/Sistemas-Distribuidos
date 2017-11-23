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

    public List<Pelicula> obtenerPeliculas(int idEstado) {
        ArrayList<Pelicula> peliculas= new ArrayList<>();
        Connection accessBD = Conexion.getConexion();
        String sql = "";
        if(idEstado==0)
            sql ="select pelicula_id, titulo, fecha_estreno,resumen,director,duracion_minutos, estado_pelicula_id\n" +
                "from db_movies_colombia.peliculas";
        else
            sql ="select pelicula_id, titulo, fecha_estreno,resumen,director,duracion_minutos, estado_pelicula_id\n" +
                "from db_movies_colombia.peliculas where estado_pelicula_id =" + idEstado;
        try{
            PreparedStatement ps = accessBD.prepareCall(sql);
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

    public List<String> obtenerPaisesProduccionPelicula(int id) {
        ArrayList<String> paises= new ArrayList<>();
        Connection accessBD = Conexion.getConexion();
        String sql= "SELECT nombre FROM db_movies_colombia.peliculas_paises_produccion p\n" +
                        "inner join db_movies_colombia.paises_produccion pp\n" +
                        "on p.pais_id = pp.pais_id\n" +
                        "where p.pelicula_id=" + id;
        try{
            PreparedStatement ps = accessBD.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                paises.add(rs.getString(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return paises;
    }

    public List<String> obtenerGenerosPelicula(int id) {
        ArrayList<String> generos= new ArrayList<>();
        Connection accessBD = Conexion.getConexion();
        String sql= "SELECT descripcion FROM db_movies_colombia.peliculas_generos p\n" +
                    "inner join db_movies_colombia.generos g\n" +
                    "on p.genero_id = g.genero_id\n" +
                    "where p.pelicula_id=" + id;
        try{
            PreparedStatement ps = accessBD.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                generos.add(rs.getString(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return generos;
    }

    List<String> obtenerIdiomasPelicula(int id) {
        ArrayList<String> idiomas= new ArrayList<>();
        Connection accessBD = Conexion.getConexion();
        String sql= "SELECT descripcion FROM db_movies_colombia.peliculas_idiomas p\n" +
                    "inner join db_movies_colombia.idiomas i\n" +
                    "on p.idioma_id = i.idioma_id\n" +
                    "where p.pelicula_id=" + id;
        try{
            PreparedStatement ps = accessBD.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                idiomas.add(rs.getString(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return idiomas;
    }
    
}
