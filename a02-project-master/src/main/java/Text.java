
import java.util.ArrayList;
import java.util.List;
/**
 * This class will handle all of the messages that pop up during the game. For example when
 * Eevee tries to run through a wall.
 */
public class Text {

    private final List<String> messageQueue;
    private final List<Integer> times;
    /**
     * This puts the text that pops up in an arraylist
     */
    public Text() {
        this.messageQueue = new ArrayList<>();
        this.times = new ArrayList<>();
    }
    /**
     * Adds text with timer
     * @param text The text that pops up
     * @param time The amount of time its on the screen.
     */
    public void addMessage(String text, int time) {
        this.messageQueue.add(text);
        this.times.add(time * 10);
    }
    /**
     * @return return the element at a given index from the specified Array.
     */
    public String getMessage() {
        try {
            this.times.set(0, this.times.get(0) - 1);

            if (this.times.get(0) <= 0) {
                this.times.remove(0);
                this.messageQueue.remove(0);
            }

            return this.messageQueue.get(0);

        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    /**
     * @return return the element at a given index from the specified Array.
     */

    public int getTime() {
        return this.times.get(0);
    }
}
