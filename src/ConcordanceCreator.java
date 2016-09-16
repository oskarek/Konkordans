import java.io.*;

/**
 * Class to create the Index part of a Concordance.
 * Created by oskarek on 2016-09-11.
 */
public class ConcordanceCreator {
    private final String SOURCE_FILE_PATH;
    private final String INDEX_LIST_FILE_PATH;
    private final String WORD_LIST_FILE_PATH;
    private final String APREFIX_FILE_PATH;

    public ConcordanceCreator(String sourcePath, String indexListPath, String wordListPath, String aprefixPath) {
        SOURCE_FILE_PATH = sourcePath;
        INDEX_LIST_FILE_PATH = indexListPath;
        WORD_LIST_FILE_PATH = wordListPath;
        APREFIX_FILE_PATH = aprefixPath;
    }

    void printFile() {
        try (
                WordListReader in = new WordListReader(SOURCE_FILE_PATH);
                IndexListWriter indexOut = new IndexListWriter(INDEX_LIST_FILE_PATH);
                WordListWriter wordOut = new WordListWriter(WORD_LIST_FILE_PATH);
                APrefixWriter aprefixOut = new APrefixWriter(APREFIX_FILE_PATH)
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