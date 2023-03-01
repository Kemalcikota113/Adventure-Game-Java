

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Using the pen and paper analogy from the documentation in "display" class we could
 * extrapolate that analogy and say that this is what is drawn. This class will define all
 * everything that the user can see in the GUI.
 */
public class output {
    public static final Rectangle messageBox = new Rectangle(305, 868, 1381, 155);

    /**
     * output Eevee on the midle of the screen
     *
     * @param eevee
     * @param graphics
     */

    public void outputEevee(Eevee eevee, Graphics graphics) {
        BufferedImage Eevee = Imges.getTexur("eevee");

        if (eevee.getDirection() == Direction.Left) {

            Eevee = Imges.getTexur("eeveeLeft");
        }
        if (eevee.getDirection() == Direction.Forward) {

            Eevee = Imges.getTexur("eeveeUP");
        }
        if (eevee.getDirection() == Direction.Back) {

            Eevee = Imges.getTexur("eeveeDOWN");
        }
        graphics.drawImage(Eevee, (Display.width / 2) - (Eevee.getWidth() / 2), (Display.hight / 2) - (Eevee.getHeight() / 2), Eevee.getWidth(), Eevee.getHeight(), null);
    }

    public void starttext(Graphics g) {
        g.drawRoundRect(304, 173, 1363, 697, 5, 5);

        //tittle
        g.setColor(Color.magenta);
        g.setFont(new Font("Serif", Font.BOLD, 60));
        g.drawString("Road to bone treats", 737, 202);
        //story
        g.setFont(new Font("Serif", Font.PLAIN, 25));
        g.setColor(Color.PINK);
        g.drawString("Hello human", 545, 362);
        g.setColor(Color.ORANGE);
        g.drawString("My name is Eevee ", 545, 420);
        g.setColor(Color.RED);
        g.drawString("Last night i dreamed of tasty meaty treats and woke up craving some..", 545, 475);
        g.setColor(Color.magenta);
        g.drawString("However decided to go back to sleep and wait until human wake up because i'm a good girl", 545, 525);
        g.setColor(Color.GREEN);
        g.drawString("But today my human was too busy coding java, and just gave me breakfast after walk", 545, 575);
        g.setColor(Color.CYAN);
        g.drawString("So i decided to get my self a treat, cause i'm worth it. Will you help me? ", 545, 625);
        g.setColor(Color.BLUE);
        g.drawString("If you want to help me press W", 545, 675);
        //instruction
        g.setColor(Color.white);
        g.drawString("Controllers:", 1511, 117);
        g.setColor(Color.CYAN);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("W", 1672, 192);
        g.drawString("A", 1550, 275);
        g.drawString("S", 1672, 275);
        g.drawString("D", 1794, 275);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.PLAIN, 25));
        g.drawString("To use a health potion press :", 1500, 424);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.setColor(Color.CYAN);
        g.drawString("H", 1700, 496);
        g.setColor(Color.magenta);
        g.drawRoundRect(10, 700, 420, 337, 10, 10);
        g.setFont(new Font("Serif", Font.PLAIN, 55));
        g.drawString("The objective :", 40, 750);
        g.setFont(new Font("Serif", Font.PLAIN, 25));
        g.setColor(Color.CYAN);
        g.drawString("Get the treat", 60, 850);
        g.drawString("Act like a good girl", 60, 950);


    }

    public void outputstats(Eevee eevee, Level ignoredRoom, Graphics2D g) {
        g.setColor(Color.magenta);
        g.drawRoundRect(1521, 35, 400, 198, 10, 10);
        g.setColor(Color.CYAN);
        g.setFont(new Font("Serif", Font.PLAIN, 35));
        g.drawString("Eevee's stats :", 1545, 75);
        g.setFont(new Font("Serif", Font.PLAIN, 25));
        g.drawString("HP :    " + eevee.getHealth(), 1560, 110);
        g.drawString("Does she have a potion :   " + eevee.getpotion(), 1560, 150);
        g.drawString("Does she have a Key :   " + eevee.getkey(), 1560, 190);

        //here add potion key bolion

    }

    public void outputLevel(Level room, Eevee eevee, Graphics g) {
        for (int y = 0; y < room.getlevelX(); y++) {
            for (int x = 0; x < room.getlevelY(); x++) {
                BufferedImage texure = Imges.getTexur(room.getAthing(x, y).getName());
                int PostionX = calculateOffsetX(texure, room.getAthing(x, y), eevee);
                int PostionY = calculateOffsetY(texure, room.getAthing(x, y), eevee);
                g.drawImage(texure, PostionX, PostionY, texure.getWidth(), texure.getHeight(), null);
            }
        }

    }

    private int calculateOffsetX(BufferedImage texure, Athing athing, Eevee eevee) {
        return athing.getPosX() * texure.getWidth() + ((Display.width / 2) - eevee.getPosX() * texure.getWidth() - (texure.getWidth() / 2)) + eevee.getOffSetX();
    }

    private int calculateOffsetY(BufferedImage texure, Athing athing, Eevee eevee) {
        return athing.getPosY() * texure.getHeight() + ((Display.hight / 2) - eevee.getPosY() * texure.getHeight() - (texure.getHeight() / 2)) + eevee.getOffSetY();
    }

    public void Textoutput(Text text, Graphics g) {
        if (text.getMessage() == null || text.getTime() <= 0) {
            return;
        }
        g.setColor(Color.BLACK);
        g.fillRoundRect(messageBox.x, messageBox.y, messageBox.width, messageBox.height, 10, 10);
        g.setColor(Color.magenta);
        g.drawRoundRect(messageBox.x, messageBox.y, messageBox.width, messageBox.height, 10, 10);

        g.setFont(new Font("Serif", Font.PLAIN, 30));
        //Center text
        try {
            int textPosX = messageBox.x + (messageBox.width - g.getFontMetrics().stringWidth(text.getMessage())) / 2;
            int textPosY = messageBox.y + ((messageBox.height - g.getFontMetrics().getHeight()) / 2) + g.getFontMetrics().getAscent();
            g.drawString(text.getMessage(), textPosX, textPosY);
        } catch (NullPointerException e) {
        }

    }


}
