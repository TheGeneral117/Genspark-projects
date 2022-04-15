import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    Goblin goblin = new Goblin(5);
    @Test
    void setPos() {
        goblin.setPos(75,75,5);
        assertFalse(Arrays.equals(new int[]{75,75},goblin.getPos()));
        assertTrue(Arrays.equals(new int[]{4,4}, goblin.getPos()));
    }

    @Test
    void Alive() {
        goblin.setHealth(0);
        assertFalse(goblin.Alive());
        goblin.setHealth(10);
        assertTrue(goblin.Alive());
    }

    @Test
    void setHealth(){
        goblin.setHealth(1);
        assertEquals(1, goblin.getHealth());
        goblin.setHealth(0);
        assertEquals(0, goblin.getHealth());
        goblin.setHealth(500);
        assertNotEquals(500, goblin.getHealth());
    }
}