import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.Group;


public class Main extends Application {

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

        // Labels allow for direct keyboard navigation
        Label nameLb1 = new Label("Enter your name:");

        TextField nameFld = new TextField();

        Label msgLbl = new Label();
        // Sets the style of the Label
        msgLbl.setStyle("-fx-text-fill: blue;");

        // Create buttons
        Button sayHelloBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");

        // Add event handler for the Say Hello button
        sayHelloBtn.setOnAction(event -> {

            String name = nameFld.getText();
            if (name.trim().length() > 0 ) {
                msgLbl.setText("Hello " + name);
            } else {
                msgLbl.setText("Hello there");
            }

        });

        // Add event handler for the exit button
        // Also where platform import is used
        exitBtn.setOnAction(event -> Platform.exit());


        /*
                The contents of the scene are arranged in a tree-like hierarchy. At the top of the hierarchy
                is the root node. The root node may contain child nodes, which in turn may contain their child nodes,
                and so on. You must have a root node to create a scene. You will use a VBox as the root node.
                VBox stands for vertical box, which arranges its children vertically in a column.
                The following statement creates a VBox:

                Tip Any node that inherits from the javafx.scene.Parent class can be used as the root node for a
                scene. Several nodes, known as layout panes or containers such as VBox, HBox, Pane, FlowPane, GridPane,
                or TilePane can be used as a root node. Group is a special container that groups its children together.

         */

        // Create a VBox node
        VBox mainSceneRoot = new VBox();

        // Set the VERTICAL spacing between children
        mainSceneRoot.setSpacing(5);

        // Create new Text node
        Text msg = new Text("Display text content not associated with an input");

        // Adds the text node to the VBox as a child node
        mainSceneRoot.getChildren().addAll(msg,nameLb1, nameFld, msgLbl, sayHelloBtn, exitBtn);



        /*
                The Scene class contains several constructors. You will use the one that lets you specify the
                root node and the size of the scene. The following statement creates a scene with the VBox as
                the root node, with 600px width and 300px height:

         */

        // Create a scene
        Scene scene = new Scene(mainSceneRoot, APP_WIDTH, APP_HEIGHT);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Set title of the primary Stage
        primaryStage.setTitle("Tower-Defense-Game");

        // Show the stage
        primaryStage.show();

        /*

                My personal code not from book may be a better way to switch between scenes, also don't
                know if other scene needs to be exited
         */
        //=============================================================================== My Code
        // Play Vbox
        VBox playSceneRoot = new VBox();

        //Play scene
        Scene playScene = new Scene(playSceneRoot, APP_WIDTH, APP_HEIGHT);

        Button playBtn = new Button("Play");

        mainSceneRoot.getChildren().add(playBtn);

        playBtn.setOnAction(event -> {

            primaryStage.setScene(playScene);

            primaryStage.show();

        });

        // ====================================================== Messing with panes
        SceneController controller = new SceneController(scene);

        Pane newPane = new Pane();

        Button backButton = new Button(("Back"));

        controller.addScreen("play", newPane);

        backButton.setOnAction(event -> {

        });
        // ============================================================ End of messing with panes
    }

    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }
}
