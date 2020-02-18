package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Eventos.EventoTaquimecanografo;
import sample.Eventos.EventoVentanaTaqui;

import java.io.File;

public class Taquimecanografo extends Stage {

    private Scene escena;
    private ToolBar tlbMenu;
    private Button btnAbrir;
    private TextArea txaTexto, txaEscritura;
    private VBox vPrincipal, vTeclado;
    private HBox hTeclas3;
    private Button[] arBotones3;
    private String[] arTeclas3 = {"->","Q","W","E","R","T","Y","U","I","O","P","`","+","E"};
    private FileChooser flcArchivos;

    public Taquimecanografo(){
        CrearGUI();
        this.setTitle("Mi tutor de mecanografía");
        this.setScene(escena);
        this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,new EventoVentanaTaqui());
        this.show();
    }

    private void CrearGUI() {
        tlbMenu = new ToolBar();
        btnAbrir = new Button();
        //btnAbrir.setPrefSize(15,15);
        btnAbrir.setGraphic(new ImageView("sample/Imagenes/open.png"));
        btnAbrir.setOnAction(event -> AbrirExplorador());
        tlbMenu.getItems().add(btnAbrir);

        txaTexto = new TextArea();
        txaTexto.setEditable(false);
        txaTexto.setPrefRowCount(5);

        txaEscritura = new TextArea();
        txaEscritura.setPrefRowCount(5);
        txaEscritura.setOnKeyPressed(new EventoTaquimecanografo());

        hTeclas3 = new HBox();
        arBotones3 = new Button[14];
        for (int i = 0; i < 14 ; i++) {
            arBotones3[i] = new Button(arTeclas3[i]);
            hTeclas3.getChildren().add(arBotones3[i]);
        }
        vTeclado = new VBox();
        vTeclado.getChildren().addAll(hTeclas3);

        vPrincipal = new VBox();
        vPrincipal.setSpacing(5);
        vPrincipal.getChildren().addAll(tlbMenu,txaTexto,txaEscritura,vTeclado);
        escena = new Scene(vPrincipal,500,350);
    }

    private void AbrirExplorador() {
        flcArchivos = new FileChooser();
        flcArchivos.setTitle("Archivo para Taquimecanógrafo");
        File objFile = flcArchivos.showOpenDialog(this);
    }

}
