import java.io.File;

/**
 * Main-klassen för programmet.
 * Created by oskarek on 2016-09-07.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("test");
        File file2 = new File("test2");
        PrefixMaker pm = new PrefixMaker(file,file2);
        pm.prefixFileMaker();
    }
}

