import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Unit tests for the WordList class.
 * 
 * @author tuna-akin
 * @version 9/23/2024
 */
public class WordListTest {

    private WordList wordList;
    private ArrayList<String> stopWords;
    private String[] tokens;

    /**
     * Set up a WordList object and test data before each test.
     */
    @BeforeEach
    public void setUp() {
        stopWords = new ArrayList<>();
        stopWords.add("the");
        stopWords.add("is");
        stopWords.add("a");
        tokens = new String[]{"the", "tuna", "fish", "is", "in", "the", "room", "coding", "coding"};

        wordList = new WordList(stopWords, tokens);
    }

    /**
     * Test the constructor and getWordFrequency method.
     * This test ensures that the wordFrequency list is built correctly, skipping stopWords.
     */
    @Test
    public void testGetWordFrequency() {
        ArrayList<Word> words = wordList.getWordFrequency();
        assertEquals(5, words.size()); // "tuna", "fish", "in", "room", "coding"

        assertEquals("tuna", words.get(0).getWord());
        assertEquals(1, words.get(0).getFrequency());

        assertEquals("fish", words.get(1).getWord());
        assertEquals(1, words.get(1).getFrequency());
        
        assertEquals("in", words.get(2).getWord());
        assertEquals(1, words.get(2).getFrequency());
        
        assertEquals("room", words.get(3).getWord());
        assertEquals(1, words.get(3).getFrequency());

        assertEquals("coding", words.get(4).getWord());
        assertEquals(2, words.get(4).getFrequency()); // "coding" appears twice
    }

    /**
     * Test the search method.
     * This test ensures that the search method correctly finds the index of a word.
     */
    @Test
    public void testSearch() {
        assertEquals(0, wordList.search("tuna"));
        assertEquals(1, wordList.search("fish"));
        assertEquals(2, wordList.search("in"));
        assertEquals(3, wordList.search("room"));
        assertEquals(4, wordList.search("coding"));
        assertEquals(-1, wordList.search("the")); // "the" is a stopWord, should not be in the list
    }

    /**
     * Test the getMostFrequent method.
     * This test ensures that the getMostFrequent method correctly identifies the most frequent word.
     */
    @Test
    public void testGetMostFrequent() {
        Word mostFrequent = wordList.getMostFrequent();
        assertEquals("coding", mostFrequent.getWord());
        assertEquals(2, mostFrequent.getFrequency());
    }

    /**
     * Test the topKMostFrequent method.
     * This test ensures that the topKMostFrequent method returns the correct top K words.
     */
    @Test
    public void testTopKMostFrequent() {
        Word[] top2 = wordList.topKMostFrequent(2);
        assertEquals("coding", top2[0].getWord());  // Most frequent
        assertEquals("tuna", top2[1].getWord());  // Next most frequent (frequency = 1)
    }

    /**
     * Test the isStopWord method.
     * This test ensures that the isStopWord method correctly identifies stopWords.
     */
    @Test
    public void testIsStopWord() {
        assertTrue(wordList.isStopWord("the", stopWords));
        assertTrue(wordList.isStopWord("is", stopWords));
        assertFalse(wordList.isStopWord("tuna", stopWords));
    }
}
