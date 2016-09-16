/**
 * Created by RobertLorentz on 13/09/16.
 */

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Concordance {
    private static final String PREFIX_FILE_PATH = "";
    private static final String I_FILE_PATH = "";

    public static void main(String[] args) {
        concordancePrinter(args[0]);
    }

    /* En funktion givet en sträng returnerar 30 tecken före och 30 tecken i dess
     * förekomster. */
    public static void concordancePrinter(String str){
        HashCalculator hc = new HashCalculator();
        int hash = hc.getHash(str);
        try {
            RandomAccessFile raf_prefix = new RandomAccessFile(PREFIX_FILE_PATH, "r");
            RandomAccessFile raf_i = new RandomAccessFile(I_FILE_PATH, "r");

            raf_prefix.seek(hash);
            int ipos = raf_prefix.read();

            raf_i.seek(ipos);
            int indexPos = raf_i.read();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
