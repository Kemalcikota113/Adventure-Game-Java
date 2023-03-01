
import javax.swing.*;
/**
 * This class will define the actions that can be made in the game. The graphicall representations
 * will in this class be defined as executables where Eevee now will be able to interact with various
 * Elements.
 */
public class GameActions {
    private static House house;
    private static Level room;

    private static Eevee eevee;
    public static boolean Story;
    private static Text text;
    /**
     * This will initialize the START of the game and all of the images
     * so all the graphics instantly load up with the start of the game.
     */

    public static void start() {
        try {
            Imges.intionlize();
            intionlizeGame();
            Timer timer = new Timer(20, new TheGame());
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }


    }
    /**
     * This will initialize the game.
     */
    public static void intionlizeGame() {
        house = new House();
        System.out.println("this is a test");
        room = house.getLevel(0);
        eevee = new Eevee(2, 3, "eevee");
        text = new Text();
        Story = true;
    }

    /**
     * @return Will return the story which is the first screen that is shown to us
     * in the start-up screen of the game.
     */
    public static boolean isStory() {
        return Story;
    }
    /** passes eevee
     * @return Eevee
     */
    public static Eevee getEevee() {
        return eevee;
    }

    /**
     * This will check whats in front of Eevee so that the action of the consumable
     * can be executed instantly. Theese executions such as potions will be executed as
     * soon as the player presses the arrows to walk in to a consumable. or if its a wall dont move her
     * @param eevee This will Read Eevee
     * @param dirictionX This will read the X direction of Eevee.
     * @param dirictionY This will read the Y direction of Eevee.
     * @return whats in front
     */
    private static Athing Whatsinfront(Eevee eevee, int dirictionX, int dirictionY) {
        return room.getAthing(eevee.getPosX() + dirictionX, eevee.getPosY() + dirictionY);
    }
    /**
     * This will simply read the NEW X and Y coordinates of Eevee when the
     * player uses the arrows to move her.
     * and dicide what will happen debendding of whats infron of her
     * @param directionX NEW x-coordinate
     * @param directionY NEW y-coordinate
     */

    public static void moveEevee(int directionX, int directionY) {
        Story = false;


        switch (Whatsinfront(eevee, directionX, directionY).getName()) {
            case "floor":
                eevee.setPostion(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                break;
            case "stairs":
                room = house.nextRoom();
                eevee.setPostion(room.getStartPositionX(), room.getStartPositionY());
                text.addMessage("maybe I'll find the bone in this room", 2000);
                break;
            case "wall":
                text.addMessage("you can't walk through wall's", 1000);
                break;
            case "chocolate":
            case "chips":
                eevee.damage(10);
                room.removeconsuble(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                eevee.setPostion(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                text.addMessage("a good dog shouldn't eat that", 600);
                break;
            case "water":
                eevee.heal(10);
                text.addMessage("water is good for dogs health", 600);
                break;
            case "key":
                eevee.pickUPkey();
                room.removeconsuble(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                eevee.setPostion(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                text.addMessage("you picked up a key", 600);
                break;
            case "door":
                if (eevee.useKey()) {
                    room.openAdoor(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                    text.addMessage("you used the key to open a door", 700);
                } else {
                    text.addMessage("you dont have a key YET!! look around", 800);
                }
                break;
            case "health":
                eevee.pickUPpotion();
                room.removeconsuble(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                eevee.setPostion(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                text.addMessage("you picked up a health potion", 800);
                break;
            case "bone":
                text.addMessage("yaaay I found the treat! yum!  thank you for your help human", 6000);
                break;
        }
    }
    /**
     * @return This gives a graphical representation of the room in our GUI.
     */
    public static Level getRoom() {
        return room;
    }
    /**
     * @return This gives a graphical representation of all the text in our GUI.
     */
    public static Text getText() {
        return text;
    }

}
