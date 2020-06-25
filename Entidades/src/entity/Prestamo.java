
package entity;

import enumeration.Denominacion;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
@XmlType(propOrder={
    "localDateTime",
    "numero",
    "pagoMoneda",
    "lineas"})

@XmlAccessorType(XmlAccessType.FIELD)
public class Prestamo {
    //Formato para poder escribir el LocalDataTime
    /***************************************************************/
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    /***************************************************************/
    
    private LocalDateTime localDateTime;
    private int numero;
    private Map<Denominacion, Moneda> pagoMoneda ;
    private Map<String, Linea> lineas;

    public Prestamo() {
    }

    public Prestamo(LocalDateTime fecha, int numero) {
        this.localDateTime = fecha;
        this.numero = numero;
        this.pagoMoneda= new HashMap<>();
        this.lineas = new HashMap<>();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Map<Denominacion, Moneda> getPagoMoneda() {
        return pagoMoneda;
    }

    public void setPagoMoneda(Map<Denominacion, Moneda> pagoMoneda) {
        this.pagoMoneda = pagoMoneda;
    }

    public Map<String, Linea> getLineas() {
        return lineas;
    }

    public void setLineas(Map<String, Linea> lineas) {
        this.lineas = lineas;
    }    
}
