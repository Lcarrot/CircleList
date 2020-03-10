import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CircleList {

    private String[] names;
    private boolean[] sex;

    public CircleList(String filename) {
        sex = new boolean[1000];
        names = new String[1000];
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            int i = 0;
            while (sc.hasNextLine()) {
                names[i] = sc.next();
                sex[i] = sc.nextLine().trim().equals("man");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    //я склонировал
}
