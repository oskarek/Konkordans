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
    }

    /* Creates the prefix */
    public void prefixFileMaker(){
        String line;
        int preHash = -4;
        HashCalc hc = new HashCalc();
        int totBytes = 0;
        int len, bytePos;
        try {
            RandomAccessFile raf = new RandomAccessFile(writeFile, "rw");
            BufferedReader br = new BufferedReader(new FileReader(readFile));

            while ((line = br.readLine()) != null) {

                String[] strs = line.split("\\s+");
                StringBuilder sb = new StringBuilder(strs[0]);
                len = sb.length();
                //Adds characters of a to the string if the length is less than 3.
                for(int i = 0; i < Math.max(0, 3-len); i++){
                    sb.append('a');
                }

                bytePos = hc.getHash(sb.toString().substring(0,3));

                if(bytePos != preHash) {
                    for(int i = preHash+4; i <= bytePos; i+=4) {
                        raf.seek(i);
                        raf.write(totBytes);
                    }
                    preHash = bytePos;
                }
                totBytes += line.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}