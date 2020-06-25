package entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class DTOResumen {
    private String mensajeError;
    private Map<Integer, ResumenLinea> coleccionLineas= new HashMap<>();
    private boolean verificarFuncion;
    private double totalPestamo;
    private double saldoMonedas;
    private double vueltas;

    public DTOResumen() {
    }

    public DTOResumen(String mensajeError, boolean agregarLinea, double totalPestamo, double saldoMonedas, double vueltas) {
        this.mensajeError = mensajeError;
        this.verificarFuncion = agregarLinea;
        this.totalPestamo = totalPestamo;
        this.saldoMonedas = saldoMonedas;
        this.vueltas = vueltas;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Map<Integer, ResumenLinea> getColeccionLineas() {
        return coleccionLineas;
    }

    public void setColeccionLineas(Map<Integer, ResumenLinea> coleccionLineas) {
        this.coleccionLineas = coleccionLineas;
    }

    public boolean isVerificarFuncion() {
        return verificarFuncion;
    }

    public void setVerificarFuncion(boolean verificarFuncion) {
        this.verificarFuncion = verificarFuncion;
    }

    public double getTotalPestamo() {
        return totalPestamo;
    }

    public void setTotalPestamo(double totalPestamo) {
        this.totalPestamo = totalPestamo;
    }

    public double getSaldoMonedas() {
        return saldoMonedas;
    }

    public void setSaldoMonedas(double saldoMonedas) {
        this.saldoMonedas = saldoMonedas;
    }

    public double getVueltas() {
        return vueltas;
    }

    public void setVueltas(double vueltas) {
        this.vueltas = vueltas;
    }
    
    
    
}
