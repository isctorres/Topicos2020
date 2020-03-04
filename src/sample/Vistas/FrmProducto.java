package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Modelos.ProductosDAO;

public class FrmProducto extends Stage{

    private ProductosDAO objP;
    private VBox vbox;
    private TextField txtDesc, txtCosto, txtPrecio, txtExistencia;
    private ComboBox cbxVigente;
    private ComboBox cbxProveedor;
    private Button btnGuardar;
    private Scene escena;
    public FrmProducto(){
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
        cbxVigente = new ComboBox();
        cbxProveedor = new ComboBox();
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
        objP.setVigente(true);
        objP.setIdProveedor(2);
        objP.insProducto();
    }
}
