/**
 * This class is the main class and from this the user will run the game.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Display.intionlize();
            GameActions.start();
            Display.setVisible();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }


    }
}

