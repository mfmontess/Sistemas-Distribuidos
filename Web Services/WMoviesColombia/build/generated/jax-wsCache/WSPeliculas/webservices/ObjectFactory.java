
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerPeliculas_QNAME = new QName("http://WebServices/", "obtenerPeliculas");
    private final static QName _ObtenerPeliculasResponse_QNAME = new QName("http://WebServices/", "obtenerPeliculasResponse");
    private final static QName _ReservarPelicula_QNAME = new QName("http://WebServices/", "reservarPelicula");
    private final static QName _ReservarPeliculaResponse_QNAME = new QName("http://WebServices/", "reservarPeliculaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerPeliculas }
     * 
     */
    public ObtenerPeliculas createObtenerPeliculas() {
        return new ObtenerPeliculas();
    }

    /**
     * Create an instance of {@link ObtenerPeliculasResponse }
     * 
     */
    public ObtenerPeliculasResponse createObtenerPeliculasResponse() {
        return new ObtenerPeliculasResponse();
    }

    /**
     * Create an instance of {@link ReservarPelicula }
     * 
     */
    public ReservarPelicula createReservarPelicula() {
        return new ReservarPelicula();
    }

    /**
     * Create an instance of {@link ReservarPeliculaResponse }
     * 
     */
    public ReservarPeliculaResponse createReservarPeliculaResponse() {
        return new ReservarPeliculaResponse();
    }

    /**
     * Create an instance of {@link Pelicula }
     * 
     */
    public Pelicula createPelicula() {
        return new Pelicula();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPeliculas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "obtenerPeliculas")
    public JAXBElement<ObtenerPeliculas> createObtenerPeliculas(ObtenerPeliculas value) {
        return new JAXBElement<ObtenerPeliculas>(_ObtenerPeliculas_QNAME, ObtenerPeliculas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPeliculasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "obtenerPeliculasResponse")
    public JAXBElement<ObtenerPeliculasResponse> createObtenerPeliculasResponse(ObtenerPeliculasResponse value) {
        return new JAXBElement<ObtenerPeliculasResponse>(_ObtenerPeliculasResponse_QNAME, ObtenerPeliculasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarPelicula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "reservarPelicula")
    public JAXBElement<ReservarPelicula> createReservarPelicula(ReservarPelicula value) {
        return new JAXBElement<ReservarPelicula>(_ReservarPelicula_QNAME, ReservarPelicula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarPeliculaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "reservarPeliculaResponse")
    public JAXBElement<ReservarPeliculaResponse> createReservarPeliculaResponse(ReservarPeliculaResponse value) {
        return new JAXBElement<ReservarPeliculaResponse>(_ReservarPeliculaResponse_QNAME, ReservarPeliculaResponse.class, null, value);
    }

}
