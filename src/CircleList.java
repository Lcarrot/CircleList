import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CircleList {

    private Participant head;
    private Participant last;
    private int size;

    private class Participant {

        private String name;
        private boolean sex;
        private Participant next;

        private Participant(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
    }

    public CircleList(Participant head, Participant last, int size) {
        this.head = head;
        this.last = last;
        this.size = size;
    }

    public CircleList(String filename) throws IOException {
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            size = 0;
            Participant participant;
            while (sc.hasNextLine()) {
                participant = (new Participant(sc.next(), sc.next().equalsIgnoreCase("man")));
                if (size == 0) {
                    head = participant;
                    size++;
                }
                last = participant;
                participant = participant.next;
                size++;
            }
            assert last != null;
            last.next = head;
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        Participant participant = head;
        for (int i = 0; i < size; i++) {
            System.out.print(participant + ", ");
            participant = participant.next;
        }
    }

    public void insert(Participant participant) {
        if (head == null) {
            head = participant;
            last = participant;
        }
        last.next = participant;
        last = participant;
        last.next = head;
    }

    public void delete(String name) {
        Participant participant = head;
        boolean flag = true;
        if (head.name.equals(name)) {
            flag = false;
            last.next = head.next;
            head = head.next;
        }
        for (int i = 0; i < size && flag; i++) {
            if (participant.next.name.equals(name)) {
                participant.next = participant.next.next;
            }
        }
    }

    public void sort(String name) {
        // TODO: 16.03.2020
    }

    public void last(int k) {
        // TODO: 16.03.2020
    }

    public CircleList[] gender() {
        Participant p = head;
        Participant[] people = new Participant[]{new Participant(null, true), new Participant(null, false)};
        Participant[] first  = new Participant[]{new Participant(null, true), new Participant(null, false)};
        Participant[] last   = new Participant[]{new Participant(null, true), new Participant(null, false)};
        int[] size = new int[]{0, 0};
        int sex;
        for (int i = 0; i < this.size; i++) {
            if (p.sex) {
                sex = 0;
            } else {
                sex = 1;
            }
            if (people[sex].name == null) {
                first[sex].name = p.name;
                people[sex] = first[sex];
                last[sex] = first[sex];
                size[sex]++;
            } else {
                people[sex].next.name = p.name;
                people[sex].next.sex = p.sex;
                people[sex] = people[sex].next;
                last[sex] = people[sex];
            }
        }
        return new CircleList[]{new CircleList(first[0],last[0],size[0]), new CircleList(first[1],last[1],size[1])};
    }
}
