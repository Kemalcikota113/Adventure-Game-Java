/**
 * This class will do all of the things necessary to compile the levels correctly.
 * This class will give us a starting position and define the amount of consumables
 * and the level-length of the level.
 */

@SuppressWarnings("SuspiciousNameCombination")
public class Level {
    private final int startPositionX;
    private final int startPositionY;
    private final Athing[][] level;

    public Level(String[] levle, int posX, int posY) {
        level = new Athing[levle.length][];
        for (int y = 0; y < levle.length; y++) {
            level[y] = new Athing[levle[y].length()];
            for (int x = 0; x < levle[y].length(); x++) {
                switch (levle[y].charAt(x)) {
                    case '.':
                        level[y][x] = new Athing(y, x, "floor");
                        break;
                    case '/':
                        level[y][x] = new Athing(y, x, "stairs");
                        break;
                    case '#':
                        level[y][x] = new Athing(y, x, "wall");
                        break;
                    case 'c':
                        level[y][x] = new Athing(y, x, "chocolate");
                        break;
                    case 'p':
                        level[y][x] = new Athing(y, x, "chips");
                        break;
                    case 'h':
                        level[y][x] = new Athing(y, x, "health");
                        break;
                    case 'b':
                        level[y][x] = new Athing(y, x, "bone");
                        break;
                    case 'k':
                        level[y][x] = new Athing(y, x, "key");
                        break;
                    case 'd':
                        level[y][x] = new Athing(y, x, "door");
                        break;
                    case 't':
                        level[y][x] = new Athing(y, x, "table");
                        break;
                    case 'w':
                        level[y][x] = new Athing(y, x, "water");
                        break;
                    case 'u':
                        level[y][x] = new Athing(y, x, "drawer");
                        break;

                }
            }
        }
        this.startPositionY = posY;
        this.startPositionX = posX;

    }
    /**
     * this method will remove a consumable when the player walks over it. So that the
     * consumable actually gets "Consumed".
     * @param PosX The x-coordinate of the consumable to be removed
     * @param PosY The y-coordinate of the consumable to be removed
     */
    public void removeconsuble(int PosX, int PosY) {
        System.out.println("checking whats infront   " + level[PosX][PosY].getName());
        switch (level[PosX][PosY].getName()) {
            case "chocolate":
            case "chips":
            case "health":
            case "bone":
            case "key":
                level[PosX][PosY] = new Athing(PosX, PosY, "floor");

        }
    }
    /**
     * This will open the door and make you enter a new level.
     * @param PosX The x-coordinate of the door to be opened
     * @param PosY The y-coordinate of the door to be opened
     */
    public void openAdoor(int PosX, int PosY) {
        if (level[PosX][PosY].getName().equals("door")) {
            level[PosX][PosY] = new Athing(PosX, PosY, "stairs");
        }
    }
    /**
     * This will load all of the "things" that the map holds. That is for example
     * walls, tiles, consumables, doors etc.
     * @param AtPostionx The X-position of the "thing".
     * @param AtPostionY The Y-position of the "thing".
     * @return
     */
    public Athing getAthing(int AtPostionx, int AtPostionY) {
        return level[AtPostionx][AtPostionY];
    }
    /**
     * @return The x-coordinate for the startposition of eevee.
     */
    public int getStartPositionX() {
        return startPositionX;
    }
    /**
     * @return  The y-coordinate for the startposition of eevee.
     */
    public int getStartPositionY() {
        return startPositionY;
    }

    public int getlevelX() {
        return level[0].length;
    }

    public int getlevelY() {
        return level.length;
    }

}
