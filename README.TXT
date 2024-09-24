## README: Word Frequency Analyzer

### Project Overview

This project is a **Word Frequency Analyzer**, which processes a given text file, filters out common stop words, and calculates the frequency of each unique word. The project reads input from two files:
1. **Pride_and_Prejudice.txt**: A text file containing the content of the book *Pride and Prejudice*.
2. **stopwords.txt**: A text file containing common stop words (e.g., "the", "is", "and"), which should be ignored during word frequency analysis.

The results are then written to a file (`Lab04.txt`), and the top 5 most frequent words are displayed in the console.

---

### Files in the Project

- **Word.java**: A class that represents a word and its frequency of occurrence. Implements the `Comparable` interface for lexicographical comparison between words.
- **WordList.java**: A class that holds a list of `Word` objects and provides methods to:
    - Process a list of tokens while filtering out stop words.
    - Search for words in the list.
    - Get the most frequent word.
    - Get the top K most frequent words.
- **Lab4Main.java**: The main class that reads the text and stop words from files, processes the words, and outputs the word frequencies to a file and console.
- **Pride_and_Prejudice.txt**: The input text file containing the text of *Pride and Prejudice*.
- **stopwords.txt**: A list of common words to ignore during the word frequency analysis.
- **Lab04.txt**: The output file where word frequencies are written.

---

### How the Program Works

1. **Read Stop Words**: 
   - The program first reads the `stopwords.txt` file and stores each stop word in a list. These words will be excluded from the frequency analysis.

2. **Process Tokens from the Text File**:
   - The program reads the `Pride_and_Prejudice.txt` file line by line, converting all text to lowercase and splitting the text into individual tokens (words).
   - Punctuation and special characters are removed using a regular expression, leaving only valid words.

3. **Create a Word Frequency List**:
   - For each word in the token list (that is not a stop word), the program either adds it to the list (with an initial frequency of 1) or increments its frequency if the word already exists.

4. **Output the Results**:
   - The program writes the word frequencies to `Lab04.txt`, where each line contains a word and its frequency.
   - The total number of unique words and the top 5 most frequent words are printed to the console.

---

### How to Run the Program

1. **Prerequisites**:
   - You need to have Java installed on your machine.

2. **Execution**:
   - Compile all the Java files using the following command:
     ```bash
     javac *.java
     ```
   - Run the program using:
     ```bash
     java Lab4Main
     ```

3. **File Requirements**:
   - Ensure the following files are present in the same directory as the compiled Java classes:
     - `Pride_and_Prejudice.txt`: The text file to process.
     - `stopwords.txt`: The file containing common stop words to exclude.
   - After running the program, a new file named `Lab04.txt` will be generated containing the word frequencies.

---

### Output

1. **Console Output**:
   - The total number of unique words.
   - The top 5 most frequent words along with their frequencies.
   
   Example:
   ```
   Total number of words in WordList: 7000
   Top 5 most frequent words:
   <chapter, 61>
   <time, 50>
   <love, 45>
   <lady, 43>
   <friend, 40>
   ```

2. **File Output (`Lab04.txt`)**:
   - A list of words and their frequencies, one word per line.
   
   Example:
   ```
   <chapter, 61>
   <time, 50>
   <love, 45>
   <lady, 43>
   <friend, 40>
   ```

---

### Key Classes and Methods

1. **Word.java**:
   - `Word(String paramWord)`: Constructor that initializes a word with frequency 1.
   - `incr()`: Increments the frequency of the word.
   - `compareTo(Word w)`: Compares two words lexicographically.

2. **WordList.java**:
   - `WordList(ArrayList<String> stopWords, String[] tokens)`: Constructor that processes tokens and filters stop words.
   - `getWordFrequency()`: Returns the list of words and their frequencies.
   - `getMostFrequent()`: Returns the most frequent word in the list.
   - `topKMostFrequent(int k)`: Returns the top `k` most frequent words.

3. **Lab4Main.java**:
   - Handles reading the input files, processing tokens, filtering stop words, and outputting results.

---

### Potential Improvements

- **Performance**: The current approach of searching for a word in the list using a linear search (`search()`) can be optimized using a more efficient data structure (e.g., a `HashMap`).
- **Error Handling**: Add more robust error handling to deal with missing or incorrectly formatted files.

---

### Author
- **Tuna Akin**
- Version: 9/23/2024
