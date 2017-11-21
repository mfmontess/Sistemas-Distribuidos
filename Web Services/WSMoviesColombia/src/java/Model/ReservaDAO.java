/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MICHAEL
 */
public class ReservaDAO {

    public int reservarPelicula(int idPelicula, int idUsuario) {
        Connection accessBD = Conexion.getConexion();
        int idReserva = 0;
        try{
            PreparedStatement ps = accessBD.prepareStatement("insert into reservas (pelicula_id,usuario_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPelicula);
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();    
            keys.next();
            idReserva = keys.getInt(1);
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return idReserva;
    }
}
