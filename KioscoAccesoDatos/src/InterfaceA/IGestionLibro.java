package InterfaceA;

import entity.DTOReporte;
import entity.Libro;
import entity.Prestamo;
import java.util.Map;

 /**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public interface IGestionLibro {
    
    public Map<String, Libro> CargarLibros();
    public boolean persistirPrestamo(Prestamo prestamo);
    public void persistirReporte(DTOReporte reported);
    
}
