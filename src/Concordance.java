/**
 * Created by RobertLorentz on 13/09/16.
 */

import java.io.RandomAccessFile;

public class Concordance {
    private static final String PREFIX_FILE_PATH = "";
    private static final String I_FILE_PATH = "";

    public static void main(String[] args) {
        concordancePrinter(args[0]);
    }

    public static void concordancePrinter(String str){
        HashCalculator hc = new HashCalculator();
        int v = hc.getHash(str);
        try {
            RandomAccessFile raf_prefix = new RandomAccessFile(PREFIX_FILE_PATH, "r");
            RandomAccessFile raf_i = new RandomAccessFile(I_FILE_PATH, "r");

            raf_prefix.seek(v);
            int ipos = raf_prefix.read();

            raf_i.seek(ipos);
            int indexPos = raf_i.read();

        } catch (Exception e){
            System.out.println("");
        }

    }
}
