package enumeration;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public enum Denominacion {
    
    QUINIENTOS(500),
    MIL(1000);
    
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    private Denominacion(double valor) {
        this.valor = valor;
    }

    private Denominacion() {
    }
    
}
