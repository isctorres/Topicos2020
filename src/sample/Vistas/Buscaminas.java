package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buscaminas extends Stage {

    private Label lblNoRows, lblNoCols;
    private TextField txtNoRows, txtNoCols;
    private Button btnMinar;
    private GridPane gdpCampo;
    private Button[][] arBtnCeldas;
    private Scene escena;
    private HBox hBox;
    private VBox vBox;

    public Buscaminas(){
        CrearGUI();
        this.setTitle("Mi Buscaminas Chido :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vBox = new VBox();

        lblNoRows = new Label("No. Rows");
        lblNoCols = new Label("No. Cols");
        txtNoRows = new TextField();
        txtNoCols = new TextField();
        hBox = new HBox();
        hBox.getChildren().addAll(lblNoRows,txtNoRows,lblNoCols,txtNoCols);
        vBox.getChildren().addAll(hBox);

        escena = new Scene(vBox,350,350);
    }









}
