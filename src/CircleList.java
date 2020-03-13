import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CircleList {

    LinkedList<Participant> participants;

    private class Participant {

        private String name;
        private boolean sex;

        private Participant(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
    }

    public CircleList(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                participants.add(new Participant(sc.next(), sc.next().equalsIgnoreCase("man")));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        for (Participant participant: participants) {
            System.out.print(participant + ", ");
        }
    }

    public void insert(Participant participant) {
        participants.add(participant);
    }

    public void delete(String name) {
        int i = 0;
        for (Participant p: participants) {
            if (p.name.equals(name)) {
                participants.remove(i);
                break;
            }
            i++;
        }
    }


}
