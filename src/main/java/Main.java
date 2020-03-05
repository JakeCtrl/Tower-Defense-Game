import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.Scene;
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

    final int APP_WIDTH = 800;
    final int APP_HEIGHT = 300;

    final int GAME_WIDTH = 1920;
    final int GAME_HEIGHT = 1080;


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

        //============================================================================= Setup play scene
        VBox playCenterLayout = new VBox();
        VBox playLeftLayout = new VBox();
        VBox playRightLayout = new VBox();

        Button diffButton = new Button("Difficulty");
        Button loadoutButton = new Button("Loadout");
        Button welcomeBackButton = new Button("Back");
        Button playNextButton = new Button("Next");

        // Center Layout
        playCenterLayout.getChildren().addAll(diffButton,loadoutButton);
        playCenterLayout.setAlignment(Pos.TOP_CENTER);
        playCenterLayout.setMargin(diffButton, new Insets(125,10,10,10));
        playCenterLayout.setMargin(loadoutButton, new Insets(10,10,10,10));

        // Left Layout
        playLeftLayout.getChildren().add(welcomeBackButton);
        playLeftLayout.setMargin(welcomeBackButton, new Insets(250,100,10,10));

        // Right Layout
        playRightLayout.getChildren().add(playNextButton);
        playLeftLayout.setMargin(playNextButton, new Insets(250,10,10,100));

        BorderPane playPane = new BorderPane();
        playPane.setCenter(playCenterLayout);
        playPane.setLeft(playLeftLayout);
        playPane.setRight(playRightLayout);

        Scene playScene = new Scene(playPane, APP_WIDTH, APP_HEIGHT);

        playButton.setOnAction(event -> {
            primaryStage.setScene(playScene);
            primaryStage.show();
        });

        welcomeBackButton.setOnAction(event -> {
            primaryStage.setScene(welcomeScene);
            primaryStage.show();
        });

        // ================================================================================ Setup game Scene
        VBox gameLayout = new VBox();
        Button tempButton = new Button("Back");

        PlayerSprite playerSprite = new PlayerSprite();
        gameLayout.getChildren().addAll(tempButton);
        gameLayout.setAlignment(Pos.BOTTOM_LEFT);
        BorderPane gamePane = new BorderPane();
        gamePane.setLeft(gameLayout);

        BackgroundImage gameBackgroundImage = new BackgroundImage(playerSprite.getSprite(),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background gameBackground = new Background(gameBackgroundImage);
        gamePane.setBackground(gameBackground);
        Scene gameScene = new Scene(gamePane, 1920, 1080 );

        playNextButton.setOnAction(event -> {
            primaryStage.setScene(gameScene);
            primaryStage.show();
        });

        tempButton.setOnAction(event -> {
            primaryStage.setScene(playScene);
            primaryStage.show();
        });


    }


    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }

}
