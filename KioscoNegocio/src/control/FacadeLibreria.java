package control;

import Constantes.constantes;
import Interface.IFacadeLibreria;
import InterfaceA.IGestionLibro;
import controlA.GestionLibro;
import entity.DTOLibrosEs;
import entity.DTOPrestamo;
import entity.DTOReporte;
import entity.DTOResumen;
import entity.Libro;
import entity.Linea;
import entity.Moneda;
import entity.Prestamo;
import entity.ResumenLinea;
import enumeration.Denominacion;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class FacadeLibreria implements IFacadeLibreria {

    private Map<String, Libro> catalogo = new HashMap<>();
    private Map<Integer, Prestamo> prestamos = new HashMap<>();
    private Prestamo prestamoActual;
    private final IGestionLibro gestionLibro = new GestionLibro();

    public FacadeLibreria() {
        this.catalogo = this.gestionLibro.CargarLibros();
    }

    public Map<String, Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Map<String, Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public Map<Integer, Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Map<Integer, Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public void setPrestamoActual(Prestamo prestamoActual) {
        this.prestamoActual = prestamoActual;
    }

    public IGestionLibro getGestionLibro() {
        return gestionLibro;
    }

    @Override
    public Map<String, Libro> obtenerCatalogo() {
        return this.catalogo;
    }

    @Override
    public Prestamo obtenerPrestamoActual() {
        return this.prestamoActual;
    }

    @Override
    public boolean crearNuevoPrestamo() {
        //Punto 2 c 
        LocalDateTime ahora = LocalDateTime.now();
        //punto 2 e 
        if (unidadesDisponiblesLibros()) {
            //Punto 2 a 
            prestamos.put(prestamos.size() + 1,
                    new Prestamo(ahora, prestamos.size() + 1));
            // Punto 2 b 
            prestamoActual = prestamos.get(prestamos.size());
            return true;
        } else {
            return false;
        }
    }

    // Punto 2 e 
    private boolean unidadesDisponiblesLibros() {
        int acom = 0;
        for (Libro lib : this.catalogo.values()) {
            acom += lib.getUnidadesDisponibles();
        }
        if (acom > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    //Buscar el libro por nombre     
    public Libro buscarLibro(String nombre) {
        for (Libro lib : this.catalogo.values()) {
            if (lib.getNombre().equals(nombre)) {
                return lib;
            }
        }
        return null;
    }

    @Override
    public DTOResumen agregarLinea(Libro lib, int cantidadLibros) {
        DTOResumen resumen = new DTOResumen();
        //Punto 3 a
        resumen.setMensajeError(verificarLibro(lib));
        if (cantidadLibros <= 0) {
            resumen.setMensajeError("No ingreso una cantidad valida");
            resumen.setVerificarFuncion(false);
            resumen.setTotalPestamo(calcularTotalPrestamo());
            return resumen;
        }
        if (resumen.getMensajeError() == null) {
            //Punto 3 b
            resumen.setMensajeError(verificarExistenciaLibro(lib, cantidadLibros));
            if (resumen.getMensajeError() == null) {
                //Punto 3 c
                crearLinea(lib, cantidadLibros);
                resumen.setVerificarFuncion(true);
                //Punto 3 d y e 
                resumen.setColeccionLineas(crearResumenLinea());
            } else {
                resumen.setVerificarFuncion(false);
            }
        } else {
            resumen.setVerificarFuncion(false);
        }
        //Punto 3 f 
        resumen.setTotalPestamo(calcularTotalPrestamo());
        //Punto 3 g 
        return resumen;
    }

    //Punto 3 a 
    private String verificarLibro(Libro lib) {
        if (this.catalogo.containsKey(lib.getIsbn())) {
            return null;
        }
        return "El Libro no se encuentra en el catálogo";
    }

    //Punto 3 b 
    private String verificarExistenciaLibro(Libro lib, int cantidadLibros) {
        int cantidad = 0;
        for (Linea lin : this.prestamoActual.getLineas().values()) {
            if (lin.getLibroEnPrestamo().getIsbn().equals(lib.getIsbn())) {
                cantidad += lin.getCantidad();
            }
        }
        cantidad += cantidadLibros;
        if (this.catalogo.get(lib.getIsbn()).getUnidadesDisponibles() >= cantidad) {
            return null;
        }
        return "No hay unidades disponibles";
    }

    //punto 3 c  
    private void crearLinea(Libro lib, int cantidadLibros) {
        boolean ver = true;
        for (Linea lin : this.prestamoActual.getLineas().values()) {
            if (lin.getLibroEnPrestamo().getIsbn().equals(lib.getIsbn())) {
                lin.setCantidad(lin.getCantidad() + cantidadLibros);
                ver = false;
            }
        }
        if (ver) {
            this.prestamoActual.getLineas().put(
                    lib.getIsbn(),
                    new Linea(cantidadLibros, lib));
        }
    }

    //Punto 3 d 
    private double calcularValorLibro(Libro lib) {
        return (lib.getPrecioBase()
                + (lib.getNumeroImagenes() * constantes.VALOR_IMAGEN)
                + (lib.getNumeroVideos() * constantes.VALOR_VIDEO));
    }

    private Map<Integer, ResumenLinea> crearResumenLinea() {
        Map<Integer, ResumenLinea> resumenLineas = new HashMap<>();
        int i = 1;
        for (Linea lin : this.prestamoActual.getLineas().values()) {
            ResumenLinea resum = new ResumenLinea();
            resum.setLinea(lin);
            resum.setSubtotalLinea(calcularSubtotalLinea(lin));
            resum.setPrecioLibro(calcularValorLibro(lin.getLibroEnPrestamo()));
            resumenLineas.put(i, resum);
            i++;
        }
        return resumenLineas;
    }

    //Punto 3 e 
    private double calcularSubtotalLinea(Linea lin) {
        return (calcularValorLibro(lin.getLibroEnPrestamo())
                * lin.getCantidad());
    }

    //Punto 3 f
    private double calcularTotalPrestamo() {
        double total = 0;
        for (Linea lin : this.prestamoActual.getLineas().values()) {
            total += calcularSubtotalLinea(lin);
        }
        return total;
    }

    //Punto 4 
    @Override
    public DTOResumen eliminarLinea(Linea lin) {
        DTOResumen resum = new DTOResumen();
        resum.setMensajeError(verificarLinea(lin));
        //Punto 4 a 
        if (resum.getMensajeError() == null) {
            //Punto 4 b
            if (buscarLinea(lin)) {
                this.prestamoActual.getLineas().remove(lin.getLibroEnPrestamo().getIsbn());
                resum.setMensajeError(null);
                resum.setVerificarFuncion(true);
            } else {
                resum.setMensajeError("La linea seleccionada no existe");
                resum.setVerificarFuncion(false);
            }
        } else {
            resum.setVerificarFuncion(false);
        }
        // Punto 4 c
        resum.setTotalPestamo(calcularTotalPrestamo());
        resum.setColeccionLineas(crearResumenLinea());
        return resum;
    }

    //Punto 4 a 
    private String verificarLinea(Linea lin) {
        if (lin == null) {
            return "No es posible eliminar la linea";
        }
        return null;
    }

    //Punto 4 b 
    private boolean buscarLinea(Linea lin) {
        return this.prestamoActual.getLineas().containsKey(lin.getLibroEnPrestamo().getIsbn());
    }

    // Punto 5 
    @Override
    public DTOResumen introducirMoneda(Denominacion demo, int canMoneda) {
        DTOResumen resum = new DTOResumen();
        resum.setMensajeError(verificarDemo(demo));
        Moneda moni;
        //Punto 5 a 
        if (canMoneda > 0) {
            if (resum.getMensajeError() == null) {
                //Punto 5 b             
                if (this.prestamoActual.getPagoMoneda().containsKey(demo)) {
                    moni = this.prestamoActual.getPagoMoneda().get(demo);
                    moni.setCantidad(moni.getCantidad() + canMoneda);
                } else {
                    //punto 5 c
                    this.prestamoActual.getPagoMoneda().put(demo, new Moneda(demo, canMoneda));
                }
                resum.setVerificarFuncion(true);
            } else {
                resum.setVerificarFuncion(false);
            }
        } else {
            resum.setVerificarFuncion(false);
            resum.setMensajeError("No ingreso una cantidad de monedas valida");
        }
        resum.setSaldoMonedas(saldoMonedas());
        return resum;
    }

    //Punto 5 a 
    private String verificarDemo(Denominacion demo) {
        if (Denominacion.MIL.equals(demo) || Denominacion.QUINIENTOS.equals(demo)) {
            return null;
        }
        return "No se encontro la numeración";
    }

    //Punto 5 d
    private double saldoMonedas() {
        double total = 0;
        for (Moneda mon : this.prestamoActual.getPagoMoneda().values()) {
            total += (mon.getCantidad() * mon.getDenominacion().getValor());
        }
        return total;
    }

    //Punto 6 
    @Override
    public DTOResumen terminarPrestamo() {
        DTOResumen resum = new DTOResumen();
        //Punto 6 a 
        resum.setMensajeError(verificarSaldo());
        if (resum.getMensajeError() == null) {
            actualizarExistencia();
            //Punto 6 c
            this.gestionLibro.persistirPrestamo(this.prestamoActual);
            //Punto 6 d
            resum.setVueltas(vueltas());
            resum.setVerificarFuncion(true);
        } else {
            resum.setVerificarFuncion(false);
        }
        return resum;
    }

    //Punto 6 a i 
    private String verificarSaldo() {
        if (calcularTotalPrestamo() > saldoMonedas()) {
            return "El dinero ingresado no alcanza a cubrir el prestamo";
        }
        return null;
    }

    //Punto 6 b
    private void actualizarExistencia() {
        for (Linea lin1 : this.prestamoActual.getLineas().values()) {
            for (Libro lib : this.catalogo.values()) {
                if (lin1.getLibroEnPrestamo().getIsbn().equals(lib.getIsbn())) {
                    lib.setUnidadesDisponibles(lib.getUnidadesDisponibles()
                            - lin1.getCantidad());
                }
            }
        }
    }

    //Punto 6 d 
    private double vueltas() {
        return (saldoMonedas() - calcularTotalPrestamo());
    }

    //Putno 7 
    @Override
    public DTOPrestamo consultarPrestamo(Integer numero) {
        DTOPrestamo prestamo = new DTOPrestamo();
        Prestamo pres = this.prestamos.get(numero);
        if (pres != null) {
            prestamo.setError(null);
            prestamo.setLocalDateTime(pres.getLocalDateTime());
            prestamo.setNumPrestamo(numero);
            this.prestamoActual = pres;
            prestamo.setTotalPrestamo(calcularTotalPrestamo());
            prestamo.setLineas(crearResumenLinea());
            prestamo.setSaldo(saldoMonedas());
            prestamo.setVueltas(prestamo.getSaldo() - prestamo.getTotalPrestamo());
        } else {
            prestamo.setError("El prestamo solicitado no existe");
        }
        return prestamo;
    }

    //Punto 8 
    @Override
    public DTOReporte reporteDiario() {
        DTOReporte reporteD = new DTOReporte();
        int cont = 0, conTLV = 0;
        double conTLP = 0;
        int monM = 0, monQ = 0, monedas = 0;
        boolean find = true;

        for (Libro lib : this.catalogo.values()) {
            for (Prestamo pres : this.prestamos.values()) {
                for (Linea lin : pres.getLineas().values()) {
                    if (lin.getLibroEnPrestamo().getIsbn().equals(lib.getIsbn())) {
                        DTOLibrosEs libes = reporteD.getLibroE().get(lin.getLibroEnPrestamo().getIsbn());
                        if (libes != null) {
                            libes.setIsbn(lin.getLibroEnPrestamo().getIsbn());
                            libes.setNombre(lin.getLibroEnPrestamo().getNombre());
                            libes.setCanTLV(libes.getCanTLV() + lin.getCantidad());
                            libes.setCanPesosLV(libes.getCanTLV() * calcularValorLibro(lin.getLibroEnPrestamo()));
                        } else {
                            libes
                                    = new DTOLibrosEs((lin.getLibroEnPrestamo().getIsbn()),
                                            (lin.getLibroEnPrestamo().getNombre()),
                                            (lin.getCantidad()), (lin.getCantidad()
                                            * calcularValorLibro(lin.getLibroEnPrestamo())));
                            reporteD.getLibroE().put(libes.getIsbn(), libes);
                        }
                        find = false;
                    }
                }
            }
            cont += lib.getUnidadesDisponibles();
            if (find) {
                reporteD.getLibroE().put(lib.getIsbn(), new DTOLibrosEs(lib.getIsbn(), lib.getNombre(), 0, 0));
            }
            find = true;
        }
        for (DTOLibrosEs libros : reporteD.getLibroE().values()) {
            conTLV += libros.getCanTLV();
            conTLP += libros.getCanPesosLV();
        }
        for (Prestamo pres : this.prestamos.values()) {
            for (Moneda mon : pres.getPagoMoneda().values()) {
                if (mon.getDenominacion().equals(Denominacion.MIL)) {
                    monM += mon.getCantidad();
                } else {
                    monQ += mon.getCantidad();
                }
                monedas += mon.getCantidad();
            }
        }
        reporteD.setCanLibro(cont);
        reporteD.setTotalLV(conTLV);
        reporteD.setTotalPLV(conTLP);
        reporteD.setTotalMonedas(monedas);
        reporteD.getCantidadMon().put(Denominacion.MIL, monM);
        reporteD.getCantidadMon().put(Denominacion.QUINIENTOS, monQ);

        //Punto 8 Nota 
        this.gestionLibro.persistirReporte(reporteD);

        return reporteD;
    }

}
