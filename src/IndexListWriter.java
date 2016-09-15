import java.io.*;

/**
 * A class that handles the writing of indexes to the index file.
 * Created by oskarek on 2016-09-13.
 */
public class IndexListWriter implements AutoCloseable {

    // The underlying BufferedOutputStream
    private final DataOutputStream out;

    public IndexListWriter(String file) throws FileNotFoundException {
        out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(file))));
    }

    /** Get current position in file */
    public int pos() {
        return out.size();
    }

    /** Write an int to file */
    public void write(int i) {
        try {
            out.writeInt(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        out.close();
    }
}
