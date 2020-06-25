package entity;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class Linea {
    private int cantidad;
    private Libro libroEnPrestamo;

    public Linea() {        
    }

    public Linea(int cantidad, Libro libroEnPrestamo) {
        this.cantidad = cantidad;
        this.libroEnPrestamo = libroEnPrestamo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibroEnPrestamo() {
        return libroEnPrestamo;
    }

    public void setLibroEnPrestamo(Libro libroEnPrestamo) {
        this.libroEnPrestamo = libroEnPrestamo;
    }
    
    
    
}
