package controlA;

import Constantes.constantes;
import InterfaceA.IGestionLibro;
import entity.ArchivoLibro;
import entity.ArchivoPrestamo;
import entity.ArchivoReporte;
import entity.DTOReporte;
import entity.Libro;
import entity.Prestamo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import javax.xml.bind.JAXB;

 /**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class GestionLibro implements IGestionLibro {

    public GestionLibro() {

    }

    //punto 1 a 
    @Override
    public Map<String, Libro> CargarLibros() {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(constantes.RUTA_ARCHIVO_LIBROS))) {
            ArchivoLibro mapalibros = JAXB.unmarshal(input, ArchivoLibro.class);
            return mapalibros.getRegistros();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

    //Punto 6 c
    @Override
    public boolean persistirPrestamo(Prestamo prestamo) {
        ArchivoPrestamo prestamos = null;
        if (prestamo.getNumero() > 1) {
            try (BufferedReader input = Files.newBufferedReader(Paths.get(constantes.RUTA_PRESTAMOS))) {
                prestamos = JAXB.unmarshal(input, ArchivoPrestamo.class);   
                prestamos.getPrestamo().put(prestamo.getNumero(), prestamo);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            prestamos = new ArchivoPrestamo(prestamo);
        }
        try (BufferedWriter output
                = Files.newBufferedWriter(Paths.get(constantes.RUTA_PRESTAMOS))) {
            JAXB.marshal(prestamos, output);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public void persistirReporte(DTOReporte reporteD) {
        ArchivoReporte reporte = new ArchivoReporte(reporteD);
        try (BufferedWriter output = Files.newBufferedWriter(Paths.get(constantes.RUTA_REPORTE))) {
            JAXB.marshal(reporte, output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
