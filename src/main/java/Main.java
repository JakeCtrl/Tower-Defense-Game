import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Main extends Application {
    public static void main(String args[]){

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

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
        VBox root = new VBox();

        // Set the VERTICAL spacing between children
        root.setSpacing(5);

        // Create new Text node
        Text msg = new Text("Display text content not associated with an input");

        // Adds the text node to the VBox as a child node
        root.getChildren().addAll(msg,nameLb1, nameFld, msgLbl, sayHelloBtn, exitBtn);

        /*
                The Scene class contains several constructors. You will use the one that lets you specify the
                root node and the size of the scene. The following statement creates a scene with the VBox as
                the root node, with 600px width and 300px height:

         */

        // Create a scene
        Scene scene = new Scene(root, 600, 300);

        // You need to set the scene to the stage by calling the setScene() method of the Stage class:

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Set title of the primary Stage
        primaryStage.setTitle("Tower-Defense-Game");

        // Show the stage
        primaryStage.show();
    }
}
