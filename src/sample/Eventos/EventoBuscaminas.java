package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class EventoBuscaminas implements EventHandler {

    private TextField txtNoRows, txtNoCols;
    private GridPane gdpCampo;
    private Button[][] arBtnCeldas;
    private VBox vBox;

    public EventoBuscaminas(TextField txtNR, TextField txtNC){

        this.txtNoRows = txtNR;
        this.txtNoCols = txtNC;

    }


    @Override
    public void handle(Event event) {
        int nr = Integer.parseInt(txtNoRows.getText());
        int nc = Integer.parseInt(txtNoCols.getText());
        arBtnCeldas = new Button[nr][nc];
    }
}
