
package webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for estadoPelicula.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoPelicula"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DISPONIBLE"/&gt;
 *     &lt;enumeration value="RESERVADA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "estadoPelicula")
@XmlEnum
public enum EstadoPelicula {

    DISPONIBLE,
    RESERVADA;

    public String value() {
        return name();
    }

    public static EstadoPelicula fromValue(String v) {
        return valueOf(v);
    }

}
