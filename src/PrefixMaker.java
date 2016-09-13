/**
 * Created by RobertLorentz on 09/09/16. Prefix creator for the program, creates three letter list which links
 * to the position where the words can be found.
 */
import java.io.*;

public class PrefixMaker {
File writeFile;
File readFile;

    public PrefixMaker(File writeFile, File readFile) {
        this.writeFile = writeFile;
        this.readFile = readFile;

        prefixFileMaker();
    }


    /* Creates the prefix */
    private void prefixFileMaker(){
        String line, previous = "";
        HashCalculator hc = new HashCalculator();
        int totBytes = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(writeFile, "rw");
            BufferedReader br = new BufferedReader(new FileReader(readFile));
            while ((line = br.readLine()) != null) {

                String[] strs = line.split("\\s+");
                if(strs[0].length() >= 3) {
                    if(previous != strs[0].substring(0,3)) {
                        previous = strs[0].substring(0,3);
                    }
                } else {
                    previous = strs[0];
                }
                System.out.println(totBytes);
                int bytePos = hc.getHash(previous);
                raf.seek(bytePos);
                raf.write(totBytes);
                totBytes += line.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}