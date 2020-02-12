package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class EventoBuscaminas implements EventHandler {

    private TextField txtNoRows, txtNoCols;
    private GridPane gdpCampo;
    private Button[][] arBtnCeldas;
    private VBox vBox;

    public EventoBuscaminas(TextField txtNR, TextField txtNC, Button[][] arBtnCeldas,GridPane gdpCampo, VBox vBox){

        this.txtNoRows = txtNR;
        this.txtNoCols = txtNC;
        this.arBtnCeldas = arBtnCeldas;
        this.gdpCampo = gdpCampo;
        this.vBox = vBox;

    }


    @Override
    public void handle(Event event) {
        int nr = Integer.parseInt(txtNoRows.getText());
        int nc = Integer.parseInt(txtNoCols.getText());

        if( arBtnCeldas != null )
            vBox.getChildren().remove(gdpCampo);

        arBtnCeldas = new Button[nr][nc];
        gdpCampo = new GridPane();
        gdpCampo.setPadding(new Insets(15));

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc ; j++) {
                arBtnCeldas[i][j] = new Button(i+"-"+j);
                arBtnCeldas[i][j].setPrefSize(50,50);
                arBtnCeldas[i][j].setStyle("-fx-base: #9ccc65; -fx-background-radius: 10;");

                gdpCampo.add(arBtnCeldas[i][j],j,i);
            }
        }

        vBox.getChildren().add(gdpCampo);
    }
}
