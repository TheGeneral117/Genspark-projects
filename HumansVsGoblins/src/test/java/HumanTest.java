import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    Human human = new Human(5);
    @Test
    void setPos() {
        human.setPos(75,75,5);
        assertFalse(Arrays.equals(new int[]{75,75},human.getPos()));
        assertTrue(Arrays.equals(new int[]{4,4}, human.getPos()));
    }

    @Test
    void Alive() {
        human.setHealth(0);
        assertFalse(human.Alive());
        human.setHealth(10);
        assertTrue(human.Alive());
    }

    @Test
    void setHealth(){
        human.setHealth(1);
        assertEquals(1, human.getHealth());
        human.setHealth(0);
        assertEquals(0, human.getHealth());
        human.setHealth(500);
        assertNotEquals(500, human.getHealth());
    }
}