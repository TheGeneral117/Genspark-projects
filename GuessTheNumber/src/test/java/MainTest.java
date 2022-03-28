import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MainTest {
    Main test;
    @BeforeEach
    void setUp(){
        test = new Main();
    }
    @Test
    void setString() {
        assertEquals("test",test.setString("test"));
    }

    @Test
    void setInt() {
        assertNull(test.setInt("not a number"));
        assertEquals(-5,test.setInt("-5"));
        assertEquals(5,test.setInt("5"));
        assertNotEquals(5,test.setInt("4"));
    }

    @Test
    void guessCheck() {
        assertEquals("yes",test.guessCheck(5,5));
        assertEquals("low",test.guessCheck(5,4));
        assertEquals("high",test.guessCheck(5,6));
    }
}