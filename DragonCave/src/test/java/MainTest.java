import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MainTest {
    Main test;
    @BeforeEach
    void setUp(){
        test = new Main();
    }

    @Test
    void setInt(){
        assertEquals(5,test.setInt("5"));
        assertNull((test.setInt("test string")));
        assertNotEquals(5,test.setInt("4"));
    }
}
