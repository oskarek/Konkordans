import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * A class that handles the writing of words with indexes to the word file.
 * Created by oskarek on 2016-09-13.
 */
public class WordListWriter implements AutoCloseable {

    // The underlying BufferedOutputStream
    private final BufferedOutputStream out;
    // The encoding to be used
    private final Charset FILE_ENCODING = StandardCharsets.ISO_8859_1;

    public WordListWriter(String file) throws FileNotFoundException {
        out = new BufferedOutputStream(new FileOutputStream(new File(file)));
    }

    public void write(String word, int index) {
        try {
            out.write(word.getBytes(FILE_ENCODING));
            out.write(' ');
            out.write(String.valueOf(index).getBytes(FILE_ENCODING));
            out.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        out.close();
    }
}
