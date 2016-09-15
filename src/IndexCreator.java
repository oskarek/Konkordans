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
        try (
                WordListReader in = new WordListReader(SOURCE_FILE_PATH);
                IndexListWriter indexOut = new IndexListWriter(INDEX_LIST_FILE_PATH);
                WordListWriter wordOut = new WordListWriter(WORD_LIST_FILE_PATH)
        ) {

            in.words().forEach((info) -> {
                wordOut.write(info.word, indexOut.pos());
                indexOut.write(info.indexCount);
                info.indexes.forEach(indexOut::write);
            });
        } catch (FileNotFoundException e) {
            System.err.println("Error in reading or writing to a file");
        } catch (Exception e) {
            System.err.println("Error in closing a file");
        }
    }

}