package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Button btn1, btn2, btn3, btn4;
    private HBox hbox;
    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        btn1 = new Button("Btn1");
        btn1.setPrefWidth(100);

        btn2 = new Button("Btn2");
        btn2.setPrefWidth(100);

        btn3 = new Button("Btn3");
        btn4 = new Button("Btn4");

        hbox = new HBox();
        vbox = new VBox();

        vbox.setSpacing(5d);
        hbox.setSpacing(5);

        vbox.getChildren().addAll(btn1,btn2);
        hbox.getChildren().addAll(btn3,btn4);
        vbox.getChildren().add(hbox);

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Hello Topicos :)");
        primaryStage.setScene(new Scene(vbox, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
