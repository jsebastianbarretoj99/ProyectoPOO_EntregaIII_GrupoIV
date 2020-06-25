package entity;

import enumeration.Denominacion;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class Moneda {
    
    private Denominacion denominacion;
    private int cantidad;

    public Moneda() {
    }

    public Moneda(Denominacion denominacion, int cantidad) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    public Denominacion getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Denominacion denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }   
}
