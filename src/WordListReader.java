import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A reader class of the sorted word-index list produced by the tokenizer.c program.
 * Implements AutoClosable so it can be used in a try-with-resources statement.
 * Created by oskarek on 2016-09-12.
 */
public class WordListReader implements AutoCloseable {

    // The underlying BufferedInputStream
    private final BufferedInputStream in;

    public WordListReader(String file) throws FileNotFoundException {
        this.in = new BufferedInputStream(new FileInputStream(new File(file)));
    }

    /** Get all the words in the file along with index information */
    public Iterable<WordInfo> words() {
        return () -> new Iterator<WordInfo>() {
            WordInfo info;
            @Override public boolean hasNext() { return (info = getWordInfo()) != null; }
            @Override public WordInfo next() { return info; }
        };
    }

    /** Get one word with its index positions */
    private WordInfo getWordInfo() {
        String word = getWord();
        // Is at end of file
        if (word.isEmpty()) return null;

        LinkedList<Integer> indexes = new LinkedList<>(); int indexCount = 0;
        in.mark(40);
        do {
            indexes.add(Integer.parseInt(getWord()));
            indexCount++;
            in.mark(40);
        } while (getWord().equals(word));
        try { in.reset(); }
        catch (IOException e) { System.err.println("Error in getWordInfo"); }

        return new WordInfo(word, indexes, indexCount);
    }

    /** Read a sequence of chars from the file, ended by whitespace */
    private String getWord() {
        StringBuilder word = new StringBuilder();
        char tkn;
        while ((tkn = getChar()) != '\n' && tkn != (char)-1 && tkn != ' ') {
            word.append(tkn);
        }
        return word.toString();
    }

    /** Read one char from the file and return it */
    private char getChar() {
        char tkn='\000';
        try { tkn=(char)in.read(); }
        catch(IOException e) { System.err.println("Error in getChar"); }
        return tkn;
    }

    @Override
    public void close() throws Exception {
        in.close();
    }
}