package entity;


import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;


/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class ArchivoPrestamo {
    
    @XmlElement(name = "Prestamo")
    
    private Map<Integer,Prestamo> prestamo = new HashMap<>();

    public ArchivoPrestamo() {
    }

    public Map<Integer,Prestamo> getPrestamo() {
        return prestamo;
    }

    public ArchivoPrestamo(Prestamo prestamo) {
        this.prestamo.put(prestamo.getNumero(), prestamo);
    }
    
}
