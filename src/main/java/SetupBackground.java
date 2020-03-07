
import javafx.scene.image.ImageView;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SetupBackground {


    public Image getBackground(String pic) throws FileNotFoundException
    {
        final String FILE_PATH = "src/main/resources/Backgrounds/" + pic;

            Image image = new Image(new FileInputStream(FILE_PATH));

            ImageView imageView = new ImageView(image);

            imageView.setX(0);
            imageView.setY(0);

            imageView.setFitHeight(455);
            imageView.setFitWidth(500);

            imageView.setPreserveRatio(true);

            return image;

    }
}
