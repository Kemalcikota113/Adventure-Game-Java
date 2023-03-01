/**
 * This class will handle all of the objects that will be presented in the game.
 * They will be assigned a X-position and Y-position and that will be their
 * position in the grid-level and a name.
 */
public class Athing {
    private final String name;

    public int mapPositionY;

    public int mappositionX;


    public Athing(int positionInX, int PositionInY, String name) {
        this.mappositionX = positionInX;
        this.mapPositionY = PositionInY;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosX() {
        return mappositionX;
    }

    public int getPosY() {
        return mapPositionY;
    }


}

