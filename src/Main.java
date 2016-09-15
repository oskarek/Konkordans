/**
 * Main-klassen för programmet.
 * Created by oskarek on 2016-09-07.
 */
public class Main {
    public static void main(String[] args) {
        IndexCreator iC = new IndexCreator("sorted_list.txt", "index_file.txt", "word_file.txt");
        iC.printFile();
    }
}

