/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author MICHAEL
 */
public class Conexion {
    public Conexion(){
        
    }
    
    public static Connection getConexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //cargar driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_movies_colombia","root","W654321*"); //realizar conexion
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
