package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Componentes.Corredor;

public class PistaAtletismo extends Stage implements EventHandler {

    private Scene escena;
    private VBox vbox;

    private Label[] lblCorredores = new Label[5];
    private String[] nmbCorredores = {"Limas","Sonic","Hulk","El prisas","Rubensin"};
    private HBox[] hBoxes = new HBox[5];

    private ProgressBar[] carriles = new ProgressBar[5];
    private Corredor[] thrCorredores = new Corredor[5];
    private Button btnIniciar;

    public PistaAtletismo(){
        CrearGUI();
        this.setTitle("Pista de Atletismo");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vbox = new VBox();
        for (int i = 0; i < carriles.length ; i++) {
            hBoxes[i] = new HBox();
            lblCorredores[i] = new Label(nmbCorredores[i]);
            carriles[i] = new ProgressBar(0);
            hBoxes[i].getChildren().addAll(lblCorredores[i],carriles[i]);
            thrCorredores[i] = new Corredor(carriles[i]);
            vbox.getChildren().add(hBoxes[i]);
        }
        btnIniciar = new Button("Iniciar Carrera");
        btnIniciar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        vbox.getChildren().add(btnIniciar);
        escena = new Scene(vbox,200,250);
    }

    @Override
    public void handle(Event event) {
        for (int i = 0; i < carriles.length ; i++) {
            thrCorredores[i].start();
        }
    }
}