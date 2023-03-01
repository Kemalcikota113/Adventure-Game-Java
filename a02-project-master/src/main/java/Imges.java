

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
/**
 * This class we create a hashmap that will store all of the images that will be
 * graphicaly represented in the game.
 */
public class Imges {
    public static HashMap<String, BufferedImage> textur;

    /**
     * store all the imges in a HashMap
     * to access later
     */
    public static void intionlize() {
        textur = new HashMap<String, BufferedImage>();

        File resources = new File("src/main/resources");

        for (File texture : Objects.requireNonNull(resources.listFiles())) {
            try {
                textur.put(texture.getName().replaceAll(".png", ""), ImageIO.read(texture));
                System.out.println(texture.getName());
            } catch (IOException e) {
                System.err.println(texture.getName());
            }

        }
        System.out.println("done storing the texurs");

    }
    /**
     * This will return the textures from the objects.
     * @param object The name of the object
     * @return the image
     */
    public static BufferedImage getTexur(String object) {
        return textur.get(object);
    }

}
