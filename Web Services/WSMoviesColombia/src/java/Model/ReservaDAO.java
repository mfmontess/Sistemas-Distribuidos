/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author MICHAEL
 */
public class ReservaDAO {

    public void reservarPelicula(int idPelicula, int idUsuario) {
        Connection accessBD = Conexion.getConexion();
        try{
            PreparedStatement ps = accessBD.prepareCall("insert into reservas (pelicula_id,usuario_id) values(?,?)");
            ps.setInt(1, idPelicula);
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
