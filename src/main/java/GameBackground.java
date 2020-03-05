
import javafx.scene.image.ImageView;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameBackground {


    public Image getSprite() throws FileNotFoundException
    {
        final String FILE_PATH = "src/main/resources/Icons/back1.jpg";

            Image image = new Image(new FileInputStream(FILE_PATH));

            ImageView imageView = new ImageView(image);

            imageView.setX(50);
            imageView.setY(25);

            imageView.setFitHeight(455);
            imageView.setFitWidth(500);

            imageView.setPreserveRatio(true);

            return image;

    }
}
