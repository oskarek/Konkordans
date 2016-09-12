/**
 * Created by RobertLorentz on 09/09/16.
 */
import java.io.*;

public class ConcordanceCreator {

    public ConcordanceCreator() {
        PrintWriter p;
        File file = new File("test");
        File writeFile = new File("aprefix");
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("aprefix")));
            Integer totBytes = 0;
            String previous = "";
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
                pw.println(previous + " " + totBytes);
                totBytes += line.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}