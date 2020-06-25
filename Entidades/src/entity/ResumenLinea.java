package entity;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class ResumenLinea {
    private Linea linea;
    private double precioLibro;
    private double subtotalLinea;

    public ResumenLinea() {
    }

    public ResumenLinea(Linea linea, double precioLibro, double subtotalLinea) {
        this.linea = linea;
        this.precioLibro = precioLibro;
        this.subtotalLinea = subtotalLinea;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public double getSubtotalLinea() {
        return subtotalLinea;
    }

    public void setSubtotalLinea(double subtotalLinea) {
        this.subtotalLinea = subtotalLinea;
    }

}
