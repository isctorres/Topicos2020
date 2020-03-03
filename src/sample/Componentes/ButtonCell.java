package sample.Componentes;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.Modelos.ProductosDAO;

public class ButtonCell extends TableCell<ProductosDAO,String> {

    private Button btnCelda;
    public ButtonCell(){
        btnCelda = new Button("Borrar");
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            setGraphic(btnCelda);
    }
}
