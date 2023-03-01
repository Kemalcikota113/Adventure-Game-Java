/**
 * This class will extend "Athing". This class will allow Eevee to pick up and interact
 * with all of the items in game that we defined in the "Athing" class.
 */
public class Eevee extends Athing {
    private int health;
    private boolean key;
    private Direction direction;
    private boolean potion;
    private int offSetX;
    private int offSetY;
    /**
     * This method will define the status and position of eevee. Because this whole
     * game works like a grid Eevee will have set X and Y values that defines her position
     * kind of like a dot on a graph with Y and X-axis.
     * @param positionInX This is for Eevees X position
     * @param PositionInY This is for Eevees Y position
     * @param name
     */
    public Eevee(int positionInX, int PositionInY, String name) {
        super(positionInX, PositionInY, name);
        this.potion = false;
        this.health = 100;
        this.key = false;
    }
    /**
     * This nethod is to check eevee potion status
     * @return True is eevee have a potion or false if she doesnt
     */
    public boolean getpotion() {
        return potion;
    }
    /**
     * This method does the same as the "GetPotion" method but with keys instead.
     * @return
     */
    public boolean getkey() {
        return key;
    }
    /**
     * This method will simply change the status of Eevees health when a potion is consumed.
     * This potion will in our case boost Eevees health by 50 units.
     */
    public void usePotion() {
        if (this.potion) {
            this.health += 50;
            this.potion = false;
        } ///print massage "you dont have a potion to use

    }
    /**
     * This method will show a true or false value if the key for the current level is picked up
     * or not. This is a boolean because there is just ONE key that can be picked up so upon opening
     * the door you can either have the key or not have the key.
     * @return True if eevee have a key or false if she doesnt
     */
    public boolean useKey() {
        if (this.key) {
            this.key = false;
            return true;
            //open the door
        } else {
            return false;
            ///print massage "you dont have a potion to use
        }
    }
    /**
     * This method changes the potion boolion when potion is picked up
     */
    public void pickUPpotion() {
        this.potion = true;
        //print massage "you picked up a potion
    }
    /**
     * This method changes the potion boolion when key is picked up
     */
    public void pickUPkey() {
        this.key = true;
        //print massage you
    }

    /**
     * this method pass the information of direction
     * @return Direction
     */
    public Direction getDirection() {
        return direction;
    }
    /**
     * this method changes direction
     */

    public void setDirection(Direction Direction) {
        this.direction = Direction;
    }

    /**
     * this method pass the information of offSetX
     * @return offSetX
     */
    public int getOffSetX() {
        return offSetX;
    }
    /**
     * this method pass the information of offSetY
     * @return offSetY
     */
    public int getOffSetY() {
        return offSetY;
    }

    /**
     * This will set the position of Eevee by the X and Y coordinates.
     * @param x Eevees X coordinate
     * @param y Eevees Y coordinate
     */
    public void setPostion(int x, int y) {
        this.mappositionX = x;
        this.mapPositionY = y;
    }
    /**
     * this method pass on health
     * @return health
     */
    public int getHealth() {
        return health;
    }
    /**
     * This will dicreace the health to simulate damge
     * decreases.
     * @param damage the daMGE
     */
    public void damage(int damage) {
        this.health -= damage;
    }
    /**
     * This will do the opposite of the "Damage" method.
     * @param heal This will increase the health value of Eevee.
     */
    public void heal(int heal) {
        this.health += heal;
    }

}
