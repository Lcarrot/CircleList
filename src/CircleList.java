import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CircleList {

    private class Participant {

        private String name;
        private boolean sex;
        private Participant next;

        private Participant(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
    }

    public CircleList(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            int i = 0;
            Participant[] participants = new Participant[1000];
            while (sc.hasNextLine()) {
                participants[i] = new Participant(sc.next(), sc.next().trim().equals("man")); //нужно реализовать через List, пока сырой код
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
