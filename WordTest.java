import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Word class.
 * 
 * @author tuna-akin
 * @version 9/23/24
 */
public class WordTest {

    private Word word;

    /**
     * Set up a Word object for testing before each test.
     */
    @BeforeEach
    public void setUp() {
        word = new Word("example");
    }

    /**
     * Test the constructor and getWord method.
     * This test ensures that the constructor initializes the word correctly.
     */
    @Test
    public void testGetWord() {
        assertEquals("example", word.getWord());
    }

    /**
     * Test the constructor and initial frequency.
     * This test ensures that the word frequency is initially 1.
     */
    @Test
    public void testInitialFrequency() {
        assertEquals(1, word.getFrequency());
    }

    /**
     * Test the incr method.
     * This test ensures that the frequency increases correctly when incr is called.
     */
    @Test
    public void testIncr() {
        word.incr();
        assertEquals(2, word.getFrequency());
        word.incr();
        assertEquals(3, word.getFrequency());
    }

    /**
     * Test the toString method.
     * This test ensures that the toString method formats the output correctly.
     */
    @Test
    public void testToString() {
        assertEquals("<example, 1>", word.toString());
        word.incr();
        assertEquals("<example, 2>", word.toString());
    }

    /**
     * Test the compareTo method.
     * This test ensures that compareTo works correctly.
     */
    @Test
    public void testCompareTo() {
        Word other = new Word("apple");
        assertTrue(word.compareTo(other) > 0);  // "example" > "apple"
        other = new Word("zebra");
        assertTrue(word.compareTo(other) < 0);  // "example" < "zebra"
        other = new Word("example");
        assertEquals(0, word.compareTo(other)); // "example" == "example"
    }
}
