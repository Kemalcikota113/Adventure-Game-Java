import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TestAthing {
    @Test
    void TestAthing() {
        Athing athing = new Athing(1, 1, "test");
        assertEquals("test",athing.getName());
        assertEquals(1,athing.getPosX());
        assertEquals(1,athing.getPosY());
    }

}
