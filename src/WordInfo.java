import java.util.LinkedList;

/**
 * Wrapper class for word-index information.
 * Created by oskarek on 2016-09-15.
 */
public class WordInfo {
    final String word;
    final LinkedList<Integer> indexes;
    final int indexCount;

    WordInfo(String word, LinkedList<Integer> indexes, int indexCount) {
        this.word = word;
        this.indexes = indexes;
        this.indexCount = indexCount;
    }

    @Override
    public String toString() {
        return word + ": " + indexes + " (" + indexCount + " occurrences)";
    }
}