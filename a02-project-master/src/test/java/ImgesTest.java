import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImgesTest {

    @Test
    void getTexur() {
        Imges.intionlize();
        try {
            BufferedImage testeevee = ImageIO.read(new File("src/main/resources/eevee.png"));
            BufferedImage eevee = Imges.getTexur("eevee");
            assertEquals(testeevee.getHeight(), eevee.getHeight());
            assertEquals(testeevee.getWidth(), eevee.getWidth());
        } catch (IOException e) {
        }

    }

}