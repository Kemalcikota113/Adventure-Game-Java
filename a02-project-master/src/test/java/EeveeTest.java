import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EeveeTest {

    @Test
    void getpotion() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        assertFalse(eevee.getpotion());
    }

    @Test
    void getkey() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        assertFalse(eevee.getkey());
    }

    @Test
    void usePotion() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        eevee.pickUPpotion();
        assertTrue(eevee.getpotion());
        eevee.usePotion();
        assertFalse(eevee.getpotion());
    }

    @Test
    void useKey() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        eevee.pickUPkey();
        assertTrue(eevee.getkey());
        eevee.useKey();
        assertFalse(eevee.getkey());
    }

    @Test
    void getDirection() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        eevee.setDirection(Direction.Left);
        assertEquals(Direction.Left, eevee.getDirection());
    }


    @Test
    void setPostion() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        eevee.setPostion(2,2);
        assertEquals(2,eevee.mappositionX);
        assertEquals(2,eevee.mapPositionY);
    }

    @Test
    void getHealth() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        assertEquals(100,eevee.getHealth());
    }

    @Test
    void damage() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        eevee.damage(50);
        assertEquals(50,eevee.getHealth());
    }

    @Test
    void heal() {
        Eevee eevee = new Eevee(1, 1, "eevee");
        eevee.heal(50);
        assertEquals(150,eevee.getHealth());
    }
}