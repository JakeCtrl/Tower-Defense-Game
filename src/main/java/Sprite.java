import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sprite {

    final String FILE_PATH = "src/main/resources/Sprites/stickMan.png";
    Image image = new Image(new FileInputStream(FILE_PATH));
    ImageView imageView = new ImageView(image);

        boolean dead = false;
        String type;

        Sprite(int x, int y, String t) throws FileNotFoundException {

            imageView.setX(x);
            imageView.setY(y);
            this.type = t;

        }

        public ImageView getSprite(){

            return imageView;
        }


}
