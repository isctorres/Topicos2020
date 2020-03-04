package sample.Componentes;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.Modelos.ProductosDAO;

import java.util.Optional;

public class ButtonCell extends TableCell<ProductosDAO,String> {

    private Button btnCelda;
    private ProductosDAO objP;

    public ButtonCell(int opc){
        if( opc == 1 ){
            btnCelda = new Button("Editar");
            btnCelda.setOnAction(event -> {

            });
        }
        else{
            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mensaje del Sistema :)");
                alert.setHeaderText("Confirmando Acción");
                alert.setContentText("¿Deseas eliminar el producto?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    objP = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    objP.delProducto();

                    // Refrescar la tabla
                    ButtonCell.this.getTableView().setItems(objP.selAllProducto());
                    ButtonCell.this.getTableView().refresh();
                }
            });
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            setGraphic(btnCelda);
    }
}
