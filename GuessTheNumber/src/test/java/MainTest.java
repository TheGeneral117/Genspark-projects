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
        assertEquals(null,test.setInt("not a number"));
        assertEquals(-5,test.setInt("-5"));
        assertEquals(5,test.setInt("5"));
    }
}