import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;



public class Main extends Application  {

    final int APP_WIDTH = 600;
    final int APP_HEIGHT = 300;

    public Main() {
        String name = Thread.currentThread().getName();
        System.out.println("Main() constructor: " + name);
    }

    public static void main(String args[]){

        Application.launch(args);

    }

    @Override
    public void init() {
        String name = Thread.currentThread().getName();
        System.out.println("init() method: " + name);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        String nameThread = Thread.currentThread().getName();
        System.out.println("start() method: " + nameThread);

        primaryStage.setTitle("Tower-Defence-Game");

        //Setup Welcome Screen
        VBox welcomeLayout = new VBox();

        Text msg = new Text("Tower-Defence-Game 2");

        Button playButton = new Button("Play");
        Button settingButton = new Button("Settings");
        welcomeLayout.getChildren().addAll(msg,playButton,settingButton);
        welcomeLayout.setAlignment(Pos.TOP_CENTER);
        welcomeLayout.setMargin(msg, new Insets(20,10,10,10));
        welcomeLayout.setMargin(playButton, new Insets(100,10,10,10));

        // Background Image
        //Image welcomeImage = new Image("C://Users//Ctrl//IdeaProjects//Tower-Defense-Game//src//main//resources//Icons");
        //ImageView mv = new ImageView(welcomeImage);
        BorderPane welcomePane = new BorderPane();
        welcomePane.setCenter(welcomeLayout);

        Scene welcomeScene = new Scene(welcomePane, APP_WIDTH, APP_HEIGHT);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();




    }


    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }

}
