package entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class DTOPrestamo {
    private LocalDateTime localDateTime;
    private int numPrestamo;
    private Map<Integer, ResumenLinea> lineas = new HashMap<>();
    private double totalPrestamo;
    private double saldo;
    private double vueltas;
    private String error;

    public DTOPrestamo() {
    }

    public DTOPrestamo(LocalDateTime localDateTime, int numPrestamo, double totalPrestamo, double saldo, double vueltas, String error) {
        this.localDateTime = localDateTime;
        this.numPrestamo = numPrestamo;
        this.totalPrestamo = totalPrestamo;
        this.saldo = saldo;
        this.vueltas = vueltas;
        this.error = error;
    }

    

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getNumPrestamo() {
        return numPrestamo;
    }

    public void setNumPrestamo(int numPrestamo) {
        this.numPrestamo = numPrestamo;
    }

    public Map<Integer, ResumenLinea> getLineas() {
        return lineas;
    }

    public void setLineas(Map<Integer, ResumenLinea> lineas) {
        this.lineas = lineas;
    }

    public double getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(double totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }   

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getVueltas() {
        return vueltas;
    }

    public void setVueltas(double vueltas) {
        this.vueltas = vueltas;
    }
    
    
}
