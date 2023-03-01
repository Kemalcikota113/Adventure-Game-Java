
import javax.swing.*;
import java.awt.*;
/**
 * This class will extend JPanel. This is the class that will initialize and create the GUI
 * for our game. This whole class could be seen as a pen and paper where everything gets
 * ready to be drawn for the user to see. But the drawing itself is done by the class "output".
 * For more information look at the documentation for "output".
 */
public class Display extends JPanel {
    public static final int width = 1980;
    public static final int hight = 1080;
    public static JFrame frame;
    public final output output;

    public static boolean Story;
    /**
     * This method contains a super class, this enables us to create the base
     * structure of the GUI from JPanel. This method also contains a "keylistener".
     * This simply "listens" to the keys inputed by the user. Sort of like an "input".
     */
    public Display() {
        super();
        this.setFocusable(true);
        this.addKeyListener(new input());
        this.output = new output();
    }

    /**
     * This method will initialize the GUI and make it visible on screen using another of swings
     * features called "JFrame". This will move and resixe all of the graphical components
     * to our liking.
     */
    public static void intionlize() {
        frame = new JFrame("Eevee's adventure");
        //Moves and resizes this component. The new location of the top-left corner is specified by x and y, and the new size is specified by width and height.
        //This method changes layout-related information, and therefore, invalidates the component hierarchy.
        frame.setBounds(25, 25, width, hight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Display display = new Display();
        frame.add(display);


    }

    public static String retruentitle() {
        return frame.getTitle();
    }
    /**
     * This will set all of the visible components in our GUI such as the character Eevee
     * and all of the other consumables and blocks.
     */
    public static void setVisible() {
        if (frame != null) frame.setVisible(true);
        {
        }
    }

    /**
     * this method display all the component of the game
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, hight);

            if (GameActions.isStory()) {
                output.starttext(g);
            } else {
                output.outputLevel(GameActions.getRoom(), GameActions.getEevee(), g);
                output.outputEevee(GameActions.getEevee(), g);
                output.outputstats(GameActions.getEevee(), GameActions.getRoom(), (Graphics2D) g);
                output.Textoutput(GameActions.getText(), g);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        repaint();
    }


}
