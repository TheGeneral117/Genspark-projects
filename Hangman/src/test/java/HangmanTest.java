import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.FileNotFoundException;

public class HangmanTest {
    Hangman test;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        test = new Hangman();
        test.setAnswer("teft");
    }

    @Test
    void setAnswer(){
        test.setAnswer("thing");
        assertEquals("thing", test.getAns());
    }

    @Test
    void guessCheck(){
        assertFalse(test.guessCheck('a'));
        assertFalse(test.guessCheck('t'));
        assertFalse(test.guessCheck('f'));
        assertTrue(test.guessCheck('e'));
        assertEquals('t', test.getCorrect()[0]);
        assertEquals('t', test.getCorrect()[3]);
        assertTrue(test.getWrong().contains('a'));
    }
}
