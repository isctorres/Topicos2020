package sample.Eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventoTaquimecanografo implements EventHandler<KeyEvent> {

    //Button objBoton;
    Button[] arBotones3;
    Boolean ban = true;

    public EventoTaquimecanografo(Button[] arreglo){
        arBotones3 = arreglo;
    }

    @Override
    public void handle(KeyEvent event) {

        int pos = 0;
        if( event.getCode() == KeyCode.TAB )
            pos = 0;

        if( event.getCode() == KeyCode.Q )
            pos = 1;


        if( ban )
            arBotones3[pos].setStyle("-fx-base: #9e9d00;");
        else
            arBotones3[pos].setStyle("-fx-base: #CCCC00;");
        ban = !ban;
    }
}
