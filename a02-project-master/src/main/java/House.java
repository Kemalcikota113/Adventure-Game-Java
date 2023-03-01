

import java.util.ArrayList;
import java.util.List;
/**
 * This class will create an arraylist with the different levels
 * that the user can travel in.
 */
public class House {
    private int room;
    private final List<Level> levels;
    /**
     * Here we create the different levels. In our case its an arraylist
     * with three objects (Levels).
     */
    public House() {
        this.levels = new ArrayList<Level>();
        this.room = 0;
        this.levels.add(room_1);
        this.levels.add(room_2);
        this.levels.add(room_3);

    }
    /**
     * return the element at a given index from the specified Array.
     * @param level
     * @return
     */
    public Level getLevel(int level) {
        return levels.get(level);

    }

    /**
     *This method will allow us to travel to new rooms when a door is entered.
     * @return This will return the new room
     */
    public Level nextRoom() {
        room += 1;
        if (room == levels.size()) {
            room -= 1;
        }
        return levels.get(room);
    }

    public int getRoom() {
        return room;
    }

    /**
     * This is an array that defines all of the building blocks in level 1
     */
    private static final Level room_1 = new Level(new String[]{
            "#########d###",
            "#...#.......#",
            "#...#..###..#",
            "#...#..###..#",
            "#......#c..k#",
            "#############"
    }, 2, 3);
    /**
     * This is an array that defines all of the building blocks in level 2
     */
    private static final Level room_2 = new Level(new String[]{
            "########################",
            "d...#.................h#",
            "#...#.#########.########",
            "#...#.#......#...#w..uc#",
            "#............#.p.#...u.#",
            "#...#.##tttt.#####...u.#",
            "#...#.##.c.t...........#",
            "#...#.##...t.###########",
            "#...#.##.....#.........#",
            "#...#.#######..###.#####",
            "#.............#k......w#",
            "########################"
    }, 2, 3);
    /**
     * This is an array that defines all of the building blocks in level 3
     */
    private static final Level room_3 = new Level(new String[]{
            "#######################################",
            "#...#................................h#",
            "#...#..##################..############",
            "#...#..###............#.....#w......uc#",
            "#.....................#..p..#.......u.#",
            "#...#..###tttttttt.##########.......u.#",
            "#...#..###..c.........................#",
            "#...#..###..c.t....##################.#",
            "#...#..###..c.t....#.........##.......#",
            "#...#..###..c.t....#.#######.#..###.###",
            "#...#..###..c.t....#.#.....#.#.#......#",
            "#...#..###..c.t....#.#####.#...########",
            "#...#..#############..#.##.######.....#",
            "#...#..###..........#.............###.#",
            "#...#..###.########.###########.#####.#",
            "#...#..###.########...................#",
            "#...#..###.##.......#######.###########",
            "#...#..###....#######.................#",
            "#...#..########.......#################",
            "#...#..###b.....#######..............h#",
            "#...#..##########........######.#######",
            "#.......................#...........w.#",
            "#######################################"
    }, 2, 3);
}
