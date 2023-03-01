import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameActionsTest {

    @Test
    void isStory() {
        GameActions.intionlizeGame();
        assertTrue(GameActions.isStory());
    }

    @Test
    void getEevee() {
        GameActions.intionlizeGame();
        assertEquals("eevee",GameActions.getEevee().getName());
    }

}