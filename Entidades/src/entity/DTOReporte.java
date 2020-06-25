package entity;

import enumeration.Denominacion;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
@XmlType(propOrder={
    "canLibro",
    "totalLV",
    "totalPLV",
    "totalMonedas",
    "cantidadMon",
    "libroE"})
public class DTOReporte {
    private int canLibro;
    private int totalLV;
    private double totalPLV;
    private int totalMonedas;
    private Map<Denominacion, Integer > cantidadMon = new HashMap<>();
    private Map<String, DTOLibrosEs> libroE = new HashMap<>(); 

    public DTOReporte() {
    }

    public DTOReporte(int canLibro, int totalLV, double totalPLV, int totalMonedas) {
        this.canLibro = canLibro;
        this.totalLV = totalLV;
        this.totalPLV = totalPLV;
        this.totalMonedas = totalMonedas;
    }

    public int getCanLibro() {
        return canLibro;
    }

    public void setCanLibro(int canLibro) {
        this.canLibro = canLibro;
    }

    public int getTotalLV() {
        return totalLV;
    }

    public void setTotalLV(int totalLV) {
        this.totalLV = totalLV;
    }

    public double getTotalPLV() {
        return totalPLV;
    }

    public void setTotalPLV(double totalPLV) {
        this.totalPLV = totalPLV;
    }

    public int getTotalMonedas() {
        return totalMonedas;
    }

    public void setTotalMonedas(int totalMonedas) {
        this.totalMonedas = totalMonedas;
    }

    public Map<String, DTOLibrosEs> getLibroE() {
        return libroE;
    }

    public void setLibroE(Map<String, DTOLibrosEs> libroE) {
        this.libroE = libroE;
    }  

    public Map<Denominacion, Integer> getCantidadMon() {
        return cantidadMon;
    }

    public void setCantidadMon(Map<Denominacion, Integer> cantidadMon) {
        this.cantidadMon = cantidadMon;
    }
    
}
