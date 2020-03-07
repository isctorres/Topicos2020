package sample.Vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Modelos.ProductosDAO;
import sample.Modelos.ProveedoresDAO;

public class FrmProducto extends Stage{

    private ProductosDAO objP;
    private TableView<ProductosDAO> tbvProductos;
    private VBox vbox;
    private TextField txtDesc, txtCosto, txtPrecio, txtExistencia;
    private ComboBox<String> cbxVigente;
    private ComboBox<ProveedoresDAO> cbxProveedor;
    private Button btnGuardar;
    private Scene escena;

    public FrmProducto(TableView<ProductosDAO> tbvProductos){
        this.tbvProductos = tbvProductos;
        CrearGUI();
        this.setTitle("Gestion de Productos :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vbox = new VBox();
        txtDesc = new TextField();
        txtDesc.setPromptText("Introduce la descripción");
        txtCosto = new TextField();
        txtCosto.setPromptText("Introduce el costo");
        txtPrecio = new TextField();
        txtPrecio.setPromptText("Introduce el precio");
        txtExistencia = new TextField();
        txtExistencia.setPromptText("Introduce la existencia");

        ObservableList<String> listVigente = FXCollections.observableArrayList();
        listVigente.addAll("Vigente","Descontinuado");
        cbxVigente = new ComboBox();
        cbxVigente.setItems(listVigente);

        cbxProveedor = new ComboBox();
        cbxProveedor.setItems(new ProveedoresDAO().selAllProveedores());

        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> guardarDatos());
        vbox.getChildren().addAll(txtDesc,txtCosto,txtPrecio,
                txtExistencia,cbxVigente,cbxProveedor,btnGuardar);
        escena = new Scene(vbox,250,250);
     }

    private void guardarDatos() {
        objP = new ProductosDAO();
        objP.setNomProducto(txtDesc.getText());
        objP.setCosto(Float.parseFloat(txtCosto.getText()));
        objP.setPrecio(Float.parseFloat(txtPrecio.getText()));
        objP.setExistencia(Integer.parseInt(txtExistencia.getText()));

        boolean ban = (cbxVigente.getValue()== "Vigente") ? true : false;
        objP.setVigente(ban);

        ProveedoresDAO objTemp = cbxProveedor.getValue();
        //cbxProveedor.getItems().get(cbxProveedor.getSelectionModel().getSelectedIndex());
        objP.setIdProveedor(objTemp.getIdProveedor());
        objP.insProducto();

        tbvProductos.setItems(objP.selAllProducto());
        tbvProductos.refresh();

        this.close();
    }
}
