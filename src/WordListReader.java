import java.io.*;

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

    /** Read a line from the file */
    private String getLine() {
        StringBuilder word = new StringBuilder();
        char tkn;
        if (EOF()) return "";
        while(!EOF() && (tkn = getChar()) != '\n') word.append(tkn);
        return word.toString();
    }

    /** Return whether the file is read to its end or not */
    private boolean EOF() {
        int n=0;
        in.mark(1);
        try {
            n=in.read();
            in.reset();
        } catch (IOException e) { System.err.println("Error in EOF\n"); }
        return (n==-1);
    }

    /** Read one char from the file and return it */
    private char getChar() {
        char tkn='\000';
        try { tkn=(char)in.read(); }
        catch(IOException e) { System.err.println("Error in getChar"); }
        return tkn;
    }

    /** Read a line and return the word with its index wrapped as a WordInfo object */
    public WordInfo getWordInfo() {
        String line = getLine();
        if (line.isEmpty()) return null;
        String[] comps = line.split("\\s+");
        String word = comps[0];
        int index = Integer.parseInt(comps[1]);
        return new WordInfo(word, index);
    }

    @Override
    public void close() throws Exception {
        in.close();
    }
}

/** Wrapper class for word-index information */
class WordInfo {
    final String word;
    final int index;

    WordInfo(String word, int index) {
        this.word = word;
        this.index = index;
    }
}