package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Vistas.Buscaminas;

public class Main extends Application {

    MenuBar mnbProyecto;
    Menu menCompetencia1, menCompentencia2, menSalir;
    MenuItem mitPractica1, mitBye;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        mnbProyecto = new MenuBar();

        menCompetencia1 = new Menu("1er. Competencia");
        menCompentencia2 = new Menu("2da. Competencia");
        menSalir = new Menu("Salir");

        mitPractica1 = new MenuItem("Buscaminas");
        mitPractica1.setOnAction(event -> OpcionMenu(1));

        mitBye = new MenuItem("Bye");
        mitBye.setOnAction(event -> OpcionMenu(20));

        menCompetencia1.getItems().addAll(mitPractica1);
        menSalir.getItems().add(mitBye);

        // Cargamos los menus al menubar
        mnbProyecto.getMenus().addAll(menCompetencia1,menCompentencia2,menSalir);

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Hello Topicos :)");
        primaryStage.setScene(new Scene(mnbProyecto, 300, 275));
        primaryStage.show();
    }

    private void OpcionMenu(int i) {
        switch (i){
            case 1:
                new Buscaminas();
                break;
            case 20:
                System.exit(0);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
