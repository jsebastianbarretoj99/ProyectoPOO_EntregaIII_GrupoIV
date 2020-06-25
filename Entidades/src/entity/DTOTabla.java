package entity;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class DTOTabla {

    private String nombre;
    private int cantidad;
    private double precioLibro;
    private double subTotalLinea;

    public DTOTabla() {
    }

    public DTOTabla(String nombre, int cantidad, double valorTlibro, double subtotal) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioLibro = valorTlibro;
        this.subTotalLinea = subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public double getSubTotalLinea() {
        return subTotalLinea;
    }

    public void setSubTotalLinea(double subTotalLinea) {
        this.subTotalLinea = subTotalLinea;
    }

}
