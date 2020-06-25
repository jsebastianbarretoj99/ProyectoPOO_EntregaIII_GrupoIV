package entity;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;

 /**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class ArchivoLibro {
    @XmlElement(name = "Catalogo")
    
    private Map<String, Libro> registros = new HashMap<>();

    public ArchivoLibro() {
    }

    public ArchivoLibro(Map<String, Libro> registros) {
        this.registros = registros;
    }

    public Map<String, Libro> getRegistros() {
        return registros;
    }

}
