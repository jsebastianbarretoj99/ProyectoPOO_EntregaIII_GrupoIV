package entity;


/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class Libro {
    
    private String isbn;
    private String nombre;
    private double precioBase;
    private int unidadesDisponibles;
    private int numeroImagenes;
    private int numeroVideos;

    public Libro() {
    }

    public Libro(String isbn, String nombre, double precioBase, int unidadesDisponibles, int numeroImagenes, int numeroVideos) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.unidadesDisponibles = unidadesDisponibles;
        this.numeroImagenes = numeroImagenes;
        this.numeroVideos = numeroVideos;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public int getNumeroImagenes() {
        return numeroImagenes;
    }

    public void setNumeroImagenes(int numeroImagenes) {
        this.numeroImagenes = numeroImagenes;
    }

    public int getNumeroVideos() {
        return numeroVideos;
    }

    public void setNumeroVideos(int numeroVideos) {
        this.numeroVideos = numeroVideos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
