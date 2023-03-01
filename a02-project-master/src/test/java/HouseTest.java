import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void getLevel() {
        House house = new House();
        Level level = house.getLevel(1);
        assertEquals(level,level);
    }

    @Test
    void nextRoom() {
        House house = new House();
        house.nextRoom();
        assertEquals(1,house.getRoom());

    }
}