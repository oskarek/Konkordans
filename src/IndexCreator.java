import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class to create the Index part of a Concordance.
 * Created by oskarek on 2016-09-11.
 */
public class IndexCreator {
    private final String SOURCE_FILE_PATH;
    private final String INDEX_LIST_FILE_PATH;
    private final String WORD_LIST_FILE_PATH;

    public IndexCreator(String sourcePath, String indexListPath, String wordListPath) {
        SOURCE_FILE_PATH = sourcePath;
        INDEX_LIST_FILE_PATH = indexListPath;
        WORD_LIST_FILE_PATH = wordListPath;
    }

    void printFile() {
        try (WordListReader in = new WordListReader(SOURCE_FILE_PATH)) {
            WordInfo info; String currWord = null;
            while ((info = in.getWordInfo()) != null) {
                // new index for same word
                if (info.word.equals(currWord)) {
                    // Should write a new index to the index file
                    System.out.print(", " + info.index);
                } else { // found a new word
                    // Should write the new word to the word file
                    // and the index to the index file
                    // as well as a index in the word file pointing to the new index
                    System.out.println();
                    currWord = info.word;
                    System.out.print(currWord + ": ");
                    System.out.print(info.index);
                }
            }
        } catch (IOException ex) {
            System.err.println("Reading or writing from a file failed.");
        } catch (Exception ex) {
            System.err.println("Unknown exception.");
        }
    }
}