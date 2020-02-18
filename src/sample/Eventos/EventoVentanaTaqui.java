package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.WindowEvent;

public class EventoVentanaTaqui implements EventHandler {
    @Override
    public void handle(Event event) {

        Alert objAlerta = new Alert(Alert.AlertType.CONFIRMATION);
        objAlerta.setTitle("Mensaje del sistema");
        objAlerta.setHeaderText("Amonos....");
        objAlerta.setContentText("Que tengan una excelente noche :)");
        objAlerta.showAndWait();
    }
}
