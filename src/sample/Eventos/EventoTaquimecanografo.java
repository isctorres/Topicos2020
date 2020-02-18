package sample.Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventoTaquimecanografo implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {

        if( event.getCode() == KeyCode.DIGIT0 )
            System.out.println("presionaste el 0");

    }
}
