package entity;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class DTOLibrosEs{
    private String isbn;
    private String nombre;
    private int canTLV;
    private double canPesosLV;

    public DTOLibrosEs() {
    }

    public DTOLibrosEs(String isbn, String nombre, int canTLV, double canPesosLV) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.canTLV = canTLV;
        this.canPesosLV = canPesosLV;
    }   

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCanTLV() {
        return canTLV;
    }

    public void setCanTLV(int canTLV) {
        this.canTLV = canTLV;
    }

    public double getCanPesosLV() {
        return canPesosLV;
    }

    public void setCanPesosLV(double canPesosLV) {
        this.canPesosLV = canPesosLV;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
