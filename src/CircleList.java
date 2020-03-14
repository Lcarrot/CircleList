import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CircleList {

    ArrayList<Participant> participants;

    private class Participant {

        private String name;
        private boolean sex;

        private Participant(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
    }

    public CircleList(String filename) throws IOException {
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                participants.add(new Participant(sc.next(), sc.next().equalsIgnoreCase("man")));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private CircleList(ArrayList<Participant> participants) {
        this.participants = participants;
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

    public void sort(String name) {
        int start = participants.indexOf(name);
        {
            //нужно спросить как сортировать, через компаратор или тот же список, но где первый это indexOf
        }
    }

    public void last(int k) {

    }

    public CircleList[] gender() {
        CircleList[] people = new CircleList[2];
        ArrayList men = new ArrayList<>();
        ArrayList<Participant> women = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.sex) {
                men.add(participant);
            }
            else {
                women.add(participant);
            }
        }
        people[0] = new CircleList(men);
        people[1] = new CircleList(women);
        return people;
    }
}
