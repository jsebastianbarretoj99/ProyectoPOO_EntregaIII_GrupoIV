package entity;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class ArchivoReporte {
    
    @XmlElement(name = "ReporteDiario")
    private DTOReporte reporte ;

    public ArchivoReporte() {
    }

    public ArchivoReporte(DTOReporte reporte) {
        this.reporte = reporte;
    }

    public DTOReporte getReporte() {
        return reporte;
    }

}