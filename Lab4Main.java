import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for Lab 4. Reads from files, processes the text to count word frequencies, and prints the result to a file and console.
 * 
 * @author tuna-akin
 * @version 9/23/2024
 */
public class Lab4Main {

    public static void main(String[] args) throws IOException {
        // Initialize stop words list
        ArrayList<String> stopWords = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        
        // Read stop words from file
        Scanner stopWordsScanner = new Scanner(new File("stopwords.txt"));
        while (stopWordsScanner.hasNext()) {
            stopWords.add(stopWordsScanner.next().toLowerCase());
        }
        stopWordsScanner.close();

        // Read text from file and extract tokens
        Scanner textScanner = new Scanner(new File("Pride_and_Prejudice.txt"));
        while (textScanner.hasNextLine()) {
            String line = textScanner.nextLine().toLowerCase(); // Convert to lowercase
            String[] words = line.split("[\\W]+"); // Split using delimiters (remove punctuation)
            for (String word : words) {
                if (!word.isEmpty()) {
                    tokens.add(word);
                }
            }
        }
        textScanner.close();
        
        // Convert tokens list to array
        String[] tokensArray = tokens.toArray(new String[0]);

        // Create WordList object
        WordList wordList = new WordList(stopWords, tokensArray);

        // Write word frequencies to Lab04.txt as directed
        FileWriter writer = new FileWriter("Lab04.txt");
        ArrayList<Word> wordFrequency = wordList.getWordFrequency();
        for (Word word : wordFrequency) {
            writer.write(word.toString() + "\n");
        }
        writer.close();
        
        // Print results to console as directed
        System.out.println("Total number of words in WordList: " + wordFrequency.size());
        
        // Get top 5 most frequent words as directed
        Word[] top5 = wordList.topKMostFrequent(5);
        System.out.println("Top 5 most frequent words:");
        for (Word word : top5) {
            System.out.println(word);
        }
    }
}
