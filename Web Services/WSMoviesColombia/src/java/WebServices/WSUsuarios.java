/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Model.Usuario;
import Model.UsuarioDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author MICHAEL
 */
@WebService(serviceName = "WSUsuarios")
public class WSUsuarios {
    
    /**
     * Metodo validar el cual obtiene un usuario deacuerdo al nombre y contraseña enviados, en caso de no encontrar alguno, retorna null
     * @param nombre Nombre del usuario a validar
     * @param contraseña Contraseña del usuario a validar
     * @return Retorna objeto usuario con el nombre y contraseña enviados
     */
    @WebMethod(operationName = "validar")
    public Usuario validar(@WebParam(name = "nombre") String nombre,@WebParam(name = "contraseña") String contraseña) {
        UsuarioDAO db = new UsuarioDAO();
        Usuario usuario = db.obtenerUsuario(nombre, contraseña);
        
        return usuario;
    }
}
