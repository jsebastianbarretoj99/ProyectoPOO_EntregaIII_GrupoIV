package Interface;


import entity.DTOPrestamo;
import entity.DTOReporte;
import entity.DTOResumen;
import entity.Libro;
import entity.Linea;
import entity.Prestamo;
import enumeration.Denominacion;
import java.util.Map;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public interface IFacadeLibreria {

    public boolean crearNuevoPrestamo();

    public DTOResumen agregarLinea(Libro lib, int cantidadLibros);

    public DTOResumen eliminarLinea(Linea lin);

    public DTOResumen introducirMoneda(Denominacion demo, int canMoneda);

    public DTOResumen terminarPrestamo();

    public DTOPrestamo consultarPrestamo(Integer numero);

    public DTOReporte reporteDiario();

    public Map<String, Libro> obtenerCatalogo();
    
    public Prestamo obtenerPrestamoActual();
    
    public Libro buscarLibro(String nombre);


}
