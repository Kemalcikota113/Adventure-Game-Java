
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class will make use of "KeyListener" to detect any sort of input that
 * the user makes on the keyboard. This will also be used to move Eevee.
 * coppeyed from this youtube vedioe
 * https://www.youtube.com/watch?v=BJ7fr9XwS2o for future refrence video explain
 */

public class input implements KeyListener {

    private static boolean[] keys;

    private static int delay;

    public input() {
        keys = new boolean[100];
        delay = 40;
    }
    /**
     *This method will read all of the input when the user presses a key
     * @param arg0 the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent arg0) {
        keys[arg0.getKeyCode()] = true;
    }
    /**
     * This methods purpose is to detect the keys beeing releases. This is because
     * we dont want the KeyListener to detect the code as beeing indefinetly pressed.
     * @param arg0 the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent arg0) {
        keys[arg0.getKeyCode()] = false;
    }

    /**
     * Checks if given key is being pressed on the keyboard
     */
    public static boolean isKeyDown(int key) {
        if (keys[key] && delay <= 0) {
            delay = 40;
            return true;
        } else {
            delay--;
            return false;
        }
    }
    /**
     * Will register if a key is typed or not.
     * @param arg0 the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent arg0) {
    }


}
