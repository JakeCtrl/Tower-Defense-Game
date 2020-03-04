import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean input;

    public static boolean display(String title, String message){
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(event -> {
            input = true;
            stage.close();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(event -> {
            input = false;
            stage.close();
        });

        // Create scene layout
        VBox vLayout = new VBox(10);
        vLayout.getChildren().add(label);
        vLayout.setAlignment(Pos.TOP_CENTER);

        HBox hLayout = new HBox(10);
        hLayout.getChildren().addAll(vLayout,yesButton, noButton);
        vLayout.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(hLayout);
        stage.setScene(scene);
        stage.showAndWait();

        return input;
    }
}
