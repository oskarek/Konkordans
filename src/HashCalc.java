/**
 * Created by RobertLorentz on 13/09/16.
 *
 */
public class HashCalc {

    /** A function given a three letter string returns a unique hashcode */
    public int getHash(String s) {
        final double totChars = 29;
        double[] cs = new double[3];
        for (int i = 0; i < 3; i++)
            cs[i] = Math.pow(totChars, (2-i)) * getCharValue(s.charAt(i));

        return (int) (4*(cs[0]+cs[1]+cs[2]));
    }

    /** Input is a character
     return value is the alphabetical number of the character */
    public int getCharValue(char c){
        int v = c;
        switch (v) {
            case 229: return 26;
            case 228: return 27;
            case 246: return 28;
            default: return v-97;
        }
    }
}
