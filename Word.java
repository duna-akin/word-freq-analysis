/**
 * The Word class represents a word with its frequency of occurrence.
 * It implements Comparable to allow comparison of words.
 * 
 * @author tuna-akin
 * @version 9/23/2024
 */
public class Word implements Comparable<Word> {
    
    // Instance variables to store the word and its frequency
    private String word;
    private int frequency;

    /**
     * Constructor for creating a Word object with an initial frequency of 1.
     * 
     * @param paramWord The word to be stored in the object.
     */
    public Word(String paramWord) {
        this.word = paramWord;
        this.frequency = 1;
    }

    /**
     * Getter method for the word variable.
     * 
     * @return The word stored in this object.
     */
    public String getWord() {
        return word; 
    }
    
    /**
     * Getter method for the frequency variable.
     * 
     * @return The current frequency of the word.
     */
    public int getFrequency() {
        return frequency;
    }
    
    /**
     * Increases the frequency of the word by 1.
     */
    public void incr() {
        frequency++;
    }
    
    /**
     * Returns a string representation of the Word object in the format "<word, frequency>".
     * 
     * @return A string representing the word and its frequency.
     */
    @Override
    public String toString() {
        return "<" + word + ", " + frequency + ">"; 
    }
    
    /**
     * Compares this word with another word.
     * 
     * @param w The Word object to compare against.
     * @return A negative, zero, or positive value if this word is less than, equal to, or greater than the specified word.
     */
    @Override
    public int compareTo(Word w) {
        return this.word.compareTo(w.word);
    }
}
