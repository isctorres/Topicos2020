package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Vistas.Buscaminas;
import sample.Vistas.Taquimecanografo;

public class Main extends Application {

    MenuBar mnbProyecto;
    Menu menCompetencia1, menCompentencia2, menSalir;
    MenuItem mitPractica1, mitPractica2, mitBye;
    Scene escena;
    BorderPane brpPrincipal;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        brpPrincipal = new BorderPane();
        mnbProyecto = new MenuBar();
        brpPrincipal.setTop(mnbProyecto);

        menCompetencia1 = new Menu("1er. Competencia");
        menCompentencia2 = new Menu("2da. Competencia");
        menSalir = new Menu("Salir");

        mitPractica1 = new MenuItem("Buscaminas");
        mitPractica1.setOnAction(event -> OpcionMenu(1));
        mitPractica2 = new MenuItem("Taquimecanografo");
        mitPractica2.setOnAction(event -> OpcionMenu(2));

        mitBye = new MenuItem("Bye");
        mitBye.setOnAction(event -> OpcionMenu(20));

        menCompetencia1.getItems().addAll(mitPractica1,mitPractica2);
        menSalir.getItems().add(mitBye);

        // Cargamos los menus al menubar
        mnbProyecto.getMenus().addAll(menCompetencia1,menCompentencia2,menSalir);
        escena = new Scene(brpPrincipal, 300, 275);
        escena.getStylesheets().add("sample/Estilos/estilos_principal.css");

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Hello Topicos :)");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void OpcionMenu(int i) {
        switch (i){
            case 1:
                new Buscaminas();
                break;
            case 2:
                new Taquimecanografo();
                break;
            case 20:
                System.exit(0);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
