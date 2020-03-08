import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CircleList {

    private LinkedList<Participant> participants;

    private class Participant {

        private String name;
        private boolean sex;

        private Participant(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
    }

    public CircleList(String filename) {
        participants = null;
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                participants.add(new Participant(sc.next(), sc.next().trim().equals("man")));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
