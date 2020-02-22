import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String args[]){

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tower-Defense-Game");

        // Show the stage
        primaryStage.show();
    }
}
