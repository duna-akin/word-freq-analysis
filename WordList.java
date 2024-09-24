import java.util.ArrayList;

/**
 * WordList class that holds a list of Word objects and provides methods to operate on the list.
 * It processes a list of tokens while filtering out stop words.
 * 
 * @author tuna-akin
 * @version 9/23/2024
 */
public class WordList {

    // List to store Word objects and their frequencies
    private ArrayList<Word> wordFrequency;

    /**
     * Constructor for WordList.
     * Initializes the wordFrequency list by processing the tokens and filtering out stopWords.
     * 
     * @param stopWords The list of words to ignore.
     * @param tokens The array of words (tokens) to process.
     */
    public WordList(ArrayList<String> stopWords, String[] tokens) {
        wordFrequency = new ArrayList<>(); // Initialize the ArrayList

        // Process each token, filtering out stop words and counting word frequencies
        for (String token : tokens) {
            if (!isStopWord(token, stopWords)) {
                int index = search(token);
                if (index == -1) {
                    // If the word is not in the list, add it
                    wordFrequency.add(new Word(token));
                } else {
                    // If the word exists, increment its frequency
                    wordFrequency.get(index).incr();
                }
            }
        }
    }

    /**
     * Returns the list of Word objects and their frequencies.
     * 
     * @return The wordFrequency list.
     */
    public ArrayList<Word> getWordFrequency() {
        return wordFrequency;
    }

    /**
     * Searches for a word in the wordFrequency list.
     * 
     * @param w The word to search for.
     * @return The index of the word in the list, or -1 if not found.
     */
    public int search(String w) {
        for (int i = 0; i < wordFrequency.size(); i++) {
            if (wordFrequency.get(i).getWord().equals(w)) {
                return i;
            }
        }
        return -1; // Word not found
    }

    /**
     * Returns the most frequent word in the wordFrequency list.
     * 
     * @return The Word object with the highest frequency, or null if the list is empty.
     */
    public Word getMostFrequent() {
        if (wordFrequency.isEmpty()) return null;

        Word mostFrequent = wordFrequency.get(0);
        // Find the word with the highest frequency
        for (Word word : wordFrequency) {
            if (word.getFrequency() > mostFrequent.getFrequency()) {
                mostFrequent = word;
            }
        }
        return mostFrequent;
    }

    /**
     * Returns the top k most frequent words.
     * 
     * @param k The number of most frequent words to return.
     * @return An array of the top k Word objects.
     */
    public Word[] topKMostFrequent(int k) {
        Word[] topK = new Word[k];
        ArrayList<Word> copyList = new ArrayList<>(wordFrequency); // Copy the wordFrequency list

        // Find the top k most frequent words
        for (int i = 0; i < k; i++) {
            Word mostFrequent = getMostFrequent();
            topK[i] = mostFrequent;
            wordFrequency.remove(mostFrequent); // Temporarily remove the most frequent word to find the next one
        }

        wordFrequency = copyList; // Restore the original list
        return topK;
    }

    /**
     * Helper method to check if a word is in the stopWords list.
     * 
     * @param word The word to check.
     * @param stopWords The list of stop words.
     * @return True if the word is a stop word, otherwise false.
     */
    protected boolean isStopWord(String word, ArrayList<String> stopWords) {
        return stopWords.contains(word);
    }
}
