import java.io.*;

/**
 * A class to handle the writing to the Aprefix file.
 * Created by oskarek on 2016-09-16.
 */
public class APrefixWriter implements AutoCloseable {
    // The underlying DataOutputStream
    private final DataOutputStream out;

    public APrefixWriter(String file) throws FileNotFoundException {
        out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(file))));
    }

    @Override
    public void close() throws Exception {

    }
}
