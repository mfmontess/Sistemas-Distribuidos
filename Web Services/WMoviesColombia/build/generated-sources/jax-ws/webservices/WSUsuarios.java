
package webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSUsuarios", targetNamespace = "http://WebServices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSUsuarios {


    /**
     * 
     * @param nombre
     * @param contraseña
     * @return
     *     returns webservices.Usuario
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validar", targetNamespace = "http://WebServices/", className = "webservices.Validar")
    @ResponseWrapper(localName = "validarResponse", targetNamespace = "http://WebServices/", className = "webservices.ValidarResponse")
    @Action(input = "http://WebServices/WSUsuarios/validarRequest", output = "http://WebServices/WSUsuarios/validarResponse")
    public Usuario validar(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "contrase\u00f1a", targetNamespace = "")
        String contraseña);

}
