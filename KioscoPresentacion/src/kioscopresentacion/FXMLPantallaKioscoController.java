package kioscopresentacion;

import Interface.IFacadeLibreria;
import control.FacadeLibreria;
import entity.DTOLibrosEs;
import entity.DTOPrestamo;
import entity.DTOReporte;
import entity.DTOResumen;
import entity.DTOTabla;
import entity.Libro;
import entity.Linea;
import entity.ResumenLinea;
import enumeration.Denominacion;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

 /**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */

public class FXMLPantallaKioscoController implements Initializable {
    
    IFacadeLibreria facadeLibreria = new FacadeLibreria();
    final static DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
    private final ObservableList<String> catalogoLibro
            = FXCollections.observableArrayList();
    private final ObservableList<Denominacion> listaDenominacion
            = FXCollections.observableArrayList();
    private final ObservableList<DTOTabla> lineas
            = FXCollections.observableArrayList();
    private final ObservableList<DTOLibrosEs> reporteLibros
            = FXCollections.observableArrayList();

    boolean verificar = true, verificar2 = false;

    @FXML
    private Label labelFecha;
    @FXML
    private ComboBox<String> cmbLibros;
    @FXML
    private TextField textCanLibro;
    @FXML
    private Button btnAgregarL;
    @FXML
    private Label labValorT;
    @FXML
    private TableView<DTOTabla> tblLibros;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField textCanMoneda;
    @FXML
    private ComboBox<Denominacion> cmbDenomina;
    @FXML
    private Button btnAgregarMon;
    @FXML
    private Label labelSaldo;
    @FXML
    private Button btnTerminar;
    @FXML
    private Label labelVueltas;
    @FXML
    private Button btnReporte;
    @FXML
    private Button btnNuevoPrestamo;
    @FXML
    private Label MensajeError;
    @FXML
    private Label labelNumeroPres;
    @FXML
    private TableColumn<DTOTabla, String> columLibro;
    @FXML
    private TableColumn<DTOTabla, Integer> colmCantidad;
    @FXML
    private TableColumn<DTOTabla, Double> columTibro;
    @FXML
    private TableColumn<DTOTabla, Double> columSub;
    @FXML
    private Button btnConsultarPres;
    @FXML
    private TextField textNumPres;
    @FXML
    private TableView<DTOLibrosEs> tablaReporte;
    @FXML
    private TableColumn<DTOLibrosEs, String> isbnLibro;
    @FXML
    private TableColumn<DTOLibrosEs, String> nombreLibro;
    @FXML
    private TableColumn<DTOLibrosEs, Integer> cantidadTotal;
    @FXML
    private TableColumn<DTOLibrosEs, Double> cantidadPesos;
    @FXML
    private Label textCantidaLibros;
    @FXML
    private Label textCantidadTotal;
    @FXML
    private Label textCantidadTotalPesos;
    @FXML
    private Label textCantidadTotalMonedas;
    @FXML
    private Label textMonedas500;
    @FXML
    private Label textMonedasMil;

    private void iniciarTabla() {
        PropertyValueFactory<DTOTabla, String> isbnProperty
                = new PropertyValueFactory<>("Nombre");
        columLibro.setCellValueFactory(isbnProperty);

        PropertyValueFactory<DTOTabla, Integer> canProperty
                = new PropertyValueFactory<>("Cantidad");
        colmCantidad.setCellValueFactory(canProperty);

        PropertyValueFactory<DTOTabla, Double> precioProperty
                = new PropertyValueFactory<>("PrecioLibro");
        columTibro.setCellValueFactory(precioProperty);

        PropertyValueFactory<DTOTabla, Double> subProperty
                = new PropertyValueFactory<>("SubTotalLinea");
        columSub.setCellValueFactory(subProperty);

    }

    private void iniciarTablaReporte() {
        PropertyValueFactory<DTOLibrosEs, String> isbnRProperty
                = new PropertyValueFactory<>("Isbn");
        isbnLibro.setCellValueFactory(isbnRProperty);

        PropertyValueFactory<DTOLibrosEs, String> nombreRProperty
                = new PropertyValueFactory<>("Nombre");
        nombreLibro.setCellValueFactory(nombreRProperty);

        PropertyValueFactory<DTOLibrosEs, Integer> canTotalProperty
                = new PropertyValueFactory<>("CanTLV");
        cantidadTotal.setCellValueFactory(canTotalProperty);

        PropertyValueFactory<DTOLibrosEs, Double> canPesosProperty
                = new PropertyValueFactory<>("CanPesosLV");
        cantidadPesos.setCellValueFactory(canPesosProperty);

    }

    //Punto 1 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final List<String> libros = new ArrayList<>();
        final List<Denominacion> moneda = new ArrayList<>();
        //Inicializar las tablas 
        iniciarTabla();
        iniciarTablaReporte();
        inicializarCasillas();
        //Listar libros 
        for (Libro lib : facadeLibreria.obtenerCatalogo().values()) {
            libros.add(lib.getNombre());
        }
        catalogoLibro.setAll(libros);
        cmbLibros.setItems(catalogoLibro);
        //Listar denominaciones        
        moneda.add(Denominacion.QUINIENTOS);
        moneda.add(Denominacion.MIL);
        listaDenominacion.setAll(moneda);
        cmbDenomina.setItems(listaDenominacion);
    }

    //Punto 2 
    @FXML
    private void IniciarPrestamo(ActionEvent event) {
        if (verificar) {
            if (facadeLibreria.crearNuevoPrestamo()) {
                inicializarCasillas();
                this.MensajeError.setText("Su prestamo ha sido creado");                
                //            
                String formattedDateTime
                        = facadeLibreria.obtenerPrestamoActual().
                                getLocalDateTime().format(formatter);
                this.labelFecha.setText(formattedDateTime);
                this.labelNumeroPres.setText(
                        Integer.toString(
                                facadeLibreria.
                                        obtenerPrestamoActual().getNumero()));

            } else {
                this.MensajeError.setText("No fue posible crear su prestamo ");
            }
            verificar = false;
            verificar2 = true;
        } else {
            this.MensajeError.setText("No se ha terminado el prestamo actual");
        }
    }

    //Punto 3 
    @FXML
    private void agregarLinea(ActionEvent event) {
        if (!verificar) {
            String nombre = cmbLibros.getValue();
            int cantidad = Integer.parseInt(textCanLibro.getText());
            DTOResumen resum;
            Libro lib_in = facadeLibreria.buscarLibro(nombre);
            if (lib_in == null) {
                MensajeError.setText("El libro seleccionado NO existe");
            } else {
                resum = facadeLibreria.agregarLinea(lib_in, cantidad);
                refrescarTabla(resum);
            }
        }
    }

    //Punto 4 
    @FXML
    private void ElimarLinea(ActionEvent event) {
        if (!verificar) {
            DTOTabla elmin = tblLibros.getSelectionModel().getSelectedItem();
            DTOResumen resum;
            final List<DTOTabla> resumLineas = new ArrayList<>();
            if (elmin != null) {
                Linea lin = new Linea(elmin.getCantidad(),
                        facadeLibreria.buscarLibro(elmin.getNombre()));
                resum = facadeLibreria.eliminarLinea(lin);
                refrescarTabla(resum);
            } else {
                MensajeError.setText("No ha seleccionado ninguna linea ");
            }
        }
    }

    //Punto 5
    @FXML
    private void agregarMoneda(ActionEvent event) {
        if (!verificar) {
            DTOResumen resum
                    = facadeLibreria.introducirMoneda(cmbDenomina.getValue(),
                            Integer.parseInt(textCanMoneda.getText()));

            if (!resum.isVerificarFuncion()) {
                MensajeError.setText(resum.getMensajeError());
            }
            labelSaldo.setText(Double.toString(resum.getSaldoMonedas()));
        }
    }

    //Punto 6 
    @FXML
    private void terminarPrestamo(ActionEvent event) {
        if (verificar2) {
            DTOResumen resum = facadeLibreria.terminarPrestamo();
            if (resum.isVerificarFuncion()) {
                labelVueltas.setText(Double.toString(resum.getVueltas()));
                verificar = true;
                verificar2 = false;
            } else {
                MensajeError.setText(resum.getMensajeError());
            }
        }
    }

    //Punto 7 
    @FXML
    private void consultarPrestamo(ActionEvent event) {

        int numero = Integer.parseInt(textNumPres.getText());

        if (numero > 0) {
            DTOPrestamo reporte
                    = facadeLibreria.consultarPrestamo(numero);
            if (reporte.getError() == null) {
                //Fecha            
                String formattedDateTime
                        = reporte.getLocalDateTime().format(formatter);
                this.labelFecha.setText(formattedDateTime);
                //Numero del prestamo 
                this.labelNumeroPres.setText(Integer.toString(reporte.getNumPrestamo()));
                //Total prestamo 
                this.labValorT.setText(Double.toString(reporte.getTotalPrestamo()));
                //Llenar la tabla
                recorridoLineas(reporte.getLineas());
                //
                this.MensajeError.setText("Su prestamo ha sido consultado");
                this.labValorT.setText(Double.toString(reporte.getTotalPrestamo()));
                this.labelVueltas.setText(Double.toString(reporte.getVueltas()));
                this.labelSaldo.setText(Double.toString(reporte.getSaldo()));
            } else {
                this.MensajeError.setText(reporte.getError());
                inicializarCasillas();
            }
        } else {

            this.MensajeError.setText("No ha inscrito ningún número de prestamo");
            inicializarCasillas();
        }
        this.textCanLibro.setText("0");
        this.textCanMoneda.setText("0");
        this.textNumPres.setText("0");
    }

    //Punto 8 
    @FXML
    private void generarReporte(ActionEvent event) {
        DTOReporte reporteD = facadeLibreria.reporteDiario();
        this.textCantidaLibros.setText(Integer.toString(reporteD.getCanLibro()));
        this.textCantidadTotal.setText(Integer.toString(reporteD.getTotalLV()));
        this.textCantidadTotalPesos.setText(Double.toString(reporteD.getTotalPLV()));
        this.textCantidadTotalMonedas.setText(Integer.toString(reporteD.getTotalMonedas()));
        this.textMonedasMil.setText(Integer.toString(reporteD.getCantidadMon().get(Denominacion.MIL)));
        this.textMonedas500.setText(Integer.toString(reporteD.getCantidadMon().get(Denominacion.QUINIENTOS)));
        reporteTabla(reporteD.getLibroE());
    }

    //Función para refrescar tabla : Punto 3 y 4 
    private void refrescarTabla(DTOResumen resum) {
        if (resum.isVerificarFuncion()) {
            recorridoLineas(resum.getColeccionLineas());
        } else {
            MensajeError.setText(resum.getMensajeError());
        }
        labValorT.setText(Double.toString(resum.getTotalPestamo()));
    }

    //Recorrido para llenar el DTOTabla 
    private void recorridoLineas(Map<Integer, ResumenLinea> nuevasLineas) {
        final List<DTOTabla> resumLineas = new ArrayList<>();
        for (ResumenLinea linea : nuevasLineas.values()) {
            DTOTabla tabla = new DTOTabla();
            tabla.setCantidad(linea.getLinea().getCantidad());
            tabla.setNombre(
                    linea.getLinea().getLibroEnPrestamo().getNombre());
            tabla.setSubTotalLinea(linea.getSubtotalLinea());
            tabla.setPrecioLibro(linea.getPrecioLibro());
            resumLineas.add(tabla);
        }
        lineas.setAll(resumLineas);
        tblLibros.setItems(lineas);
    }

    //Inicializar valores
    private void inicializarCasillas() {
        tblLibros.setItems(null);
        this.textCanLibro.setText("0");
        this.textCanMoneda.setText("0");
        this.labelSaldo.setText("0");
        this.labValorT.setText("0");
        this.labelVueltas.setText("0");
        this.labelNumeroPres.setText("0");
        this.labelFecha.setText("dd/mm/aa 00:00:00");
        tablaReporte.setItems(null);
        this.textCantidaLibros.setText("0");
        this.textCantidadTotal.setText("0");
        this.textCantidadTotalPesos.setText("0");
        this.textCantidadTotalMonedas.setText("0");
        this.textMonedasMil.setText("0");
        this.textMonedas500.setText("0");
    }

    // LLenar reporte tabla 
    private void reporteTabla(Map<String, DTOLibrosEs> libroE) {
        final List<DTOLibrosEs> resumReporte = new ArrayList<>();
        for (DTOLibrosEs libros : libroE.values()) {
            DTOLibrosEs tabla = new DTOLibrosEs();
            tabla.setIsbn(libros.getIsbn());
            tabla.setNombre(libros.getNombre());
            tabla.setCanTLV(libros.getCanTLV());
            tabla.setCanPesosLV(libros.getCanPesosLV());
            resumReporte.add(tabla);
        }
        reporteLibros.setAll(resumReporte);
        tablaReporte.setItems(reporteLibros);
    }

}
