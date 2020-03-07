import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.text.Text;

import javafx.scene.control.Button;

import javafx.geometry.Insets;


public class Main extends Application  {

    final int APP_WIDTH = 800;
    final int APP_HEIGHT = 300;

    final int GAME_WIDTH = 1280;
    final int GAME_HEIGHT = 720;


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

        /*TODO:
          Get fullscreen working
          Get 2 Other resolution presets
          Create User inputs
          Create Collision
          Fix scalability

         */

        String nameThread = Thread.currentThread().getName();
        System.out.println("start() method: " + nameThread);

        primaryStage.setTitle("Tower-Defence-Game");

        //========================================================================================== Setup Welcome Screen
        VBox welcomeLayout = new VBox();

        Text msg = new Text("Tower-Defence-Game 2");

        Button playButton = new Button("Play");
        playButton.setPrefHeight(100);
        playButton.setPrefWidth(150);
        Button settingButton = new Button("Settings");
        settingButton.setPrefHeight(100);
        settingButton.setPrefWidth(150);
        welcomeLayout.getChildren().addAll(msg,playButton,settingButton);
        welcomeLayout.setAlignment(Pos.TOP_CENTER);
        welcomeLayout.setMargin(msg, new Insets(20,10,10,10));
        welcomeLayout.setMargin(playButton, new Insets(300,10,10,10));

        BorderPane welcomePane = new BorderPane();
        welcomePane.setCenter(welcomeLayout);

        SetupBackground animeBackgroundSetup = new SetupBackground();
        BackgroundImage animeBackgroundImage = new BackgroundImage(animeBackgroundSetup.getBackground("animeBack.jpg"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background animeBackground = new Background(animeBackgroundImage);
        welcomePane.setBackground(animeBackground);

        Scene welcomeScene = new Scene(welcomePane, GAME_WIDTH,GAME_HEIGHT);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

        //============================================================================= Setup play scene
        VBox playCenterLayout = new VBox();
        VBox playLeftLayout = new VBox();
        VBox playRightLayout = new VBox();

        Button diffButton = new Button("Difficulty");
        diffButton.setPrefHeight(100);
        diffButton.setPrefWidth(150);
        Button loadoutButton = new Button("Loadout");
        loadoutButton.setPrefHeight(100);
        loadoutButton.setPrefWidth(150);
        Button welcomeBackButton = new Button("Back");
        Button playNextButton = new Button("Next");

        // Center Layout
        playCenterLayout.getChildren().addAll(diffButton,loadoutButton);
        playCenterLayout.setAlignment(Pos.TOP_CENTER);
        playCenterLayout.setMargin(diffButton, new Insets(350,10,10,10));
        playCenterLayout.setMargin(loadoutButton, new Insets(0,10,10,10));

        // Left Layout
        playLeftLayout.getChildren().add(welcomeBackButton);
        playLeftLayout.setMargin(welcomeBackButton, new Insets(690,100,10,10));

        // Right Layout
        playRightLayout.getChildren().add(playNextButton);
        playLeftLayout.setMargin(playNextButton, new Insets(690,10,10,100));

        BorderPane playPane = new BorderPane();
        playPane.setCenter(playCenterLayout);
        playPane.setLeft(playLeftLayout);
        playPane.setRight(playRightLayout);

        SetupBackground playBackgroundSetup = new SetupBackground();
        BackgroundImage playBackgroundImage = new BackgroundImage(playBackgroundSetup.getBackground("animeBack2.jpg"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background playBackground = new Background(playBackgroundImage);
        playPane.setBackground(playBackground);

        Scene playScene = new Scene(playPane, GAME_WIDTH,GAME_HEIGHT);

        playButton.setOnAction(event -> {
            primaryStage.setScene(playScene);
            primaryStage.show();
        });

        welcomeBackButton.setOnAction(event -> {
            primaryStage.setScene(welcomeScene);
            primaryStage.show();
        });

        // ================================================================================ Setup game Scene

        GameScene gameScene = new GameScene(primaryStage);
        gameScene.setPrevScene(playScene);

        playNextButton.setOnAction(event -> {
            primaryStage.setScene(gameScene.getGameScene());
            primaryStage.show();
        });




    }


    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }

}
