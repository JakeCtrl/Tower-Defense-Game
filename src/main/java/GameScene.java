import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class GameScene {

    final int GAME_WIDTH = 1280;
    final int GAME_HEIGHT = 720;
    Scene gameScene;
    Scene prevScene;

    GameScene(Stage gameStage) throws FileNotFoundException {
        VBox gameLayout = new VBox();
        Button tempButton = new Button("Back");

        SetupBackground background = new SetupBackground();
        gameLayout.getChildren().addAll(tempButton);
        gameLayout.setAlignment(Pos.BOTTOM_LEFT);
        BorderPane gamePane = new BorderPane();
        gamePane.setLeft(gameLayout);

        BackgroundImage gameBackgroundImage = new BackgroundImage(background.getBackground("back2.jpg"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background gameBackground = new Background(gameBackgroundImage);
        gamePane.setBackground(gameBackground);
        gameScene = new Scene(gamePane, GAME_WIDTH,GAME_HEIGHT);

        tempButton.setOnAction(event -> {
            gameStage.setScene(prevScene);
            gameStage.show();
        });

        /*
                TODO:
                1. Create a sprite on screen
                2. Create movement for sprite
                4. Create health for sprite
                5. Create enemy
                6. Create bounds in which the sprite can move

         */


    }

    public void setPrevScene(Scene prev){
        this.prevScene = prev;
    }

    public Scene getGameScene(){
        return gameScene;
    }

    public Scene getPrevScene(){
        return prevScene;
    }



}
