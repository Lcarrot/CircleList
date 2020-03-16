import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CircleList {

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

    public CircleList(Participant last, int size) {
        this.last = last;
        this.size = size;
    }

    public CircleList(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Scanner sc = new Scanner(reader);
            size = 0;
            Participant head = null;
            Participant participant;
            while (sc.hasNextLine()) {
                participant = (new Participant(sc.next(), sc.next().equalsIgnoreCase("man")));
                if (size == 0) {
                    head = participant;
                }
                last = participant;
                participant = participant.next;
                size++;
            }
            assert last != null;
            last.next = head;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        Participant participant = last.next;
        for (int i = 0; i < size; i++) {
            System.out.print(participant + ", ");
            participant = participant.next;
        }
    }

    public void insert(Participant participant) {
        if (last == null) {
            last = participant;
        }
        participant.next = last.next;
        last.next = participant;
        last = participant;
    }

    public void delete(String name) {
        Participant participant = last.next;
        boolean flag = true;
        if (last.next.name.equals(name)) {
            flag = false;
            last.next = last.next.next;
        }
        for (int i = 0; i < size && flag; i++) {
            if (participant.next.name.equals(name)) {
                participant.next = participant.next.next;
            }
        }
    }

    public void sort(String name) {
        Participant p = last;
        for (int i = 0; i < size; i++) {
            if (p.next.name.equals(name)) {
                last = p;
                break;
            }
            p = p.next;
        }
    }

    public void last(int k) {
        Participant p = last;
        if (size > 0) {
            int n = size;
            while (n > 1) {
                int s = (n % k) - 1;
                for (int i = 0; i < s; i++) {
                   p = p.next;
                }
                p.next = p.next.next;
                n--;
            }
        }
    }

    public CircleList[] gender() {
        Participant p = last.next;
        Participant[] people = new Participant[]{new Participant(null, true), new Participant(null, false)};
        Participant[] lasts = new Participant[]{new Participant(null, true), new Participant(null, false)};
        Participant[] firsts = new Participant[]{new Participant(null, true), new Participant(null, false)};
        int[] size = new int[]{0, 0};
        int sex;
        for (int i = 0; i < this.size; i++) {
            if (p.sex) {
                sex = 0;
            } else {
                sex = 1;
            }
            if (people[sex].name == null) {
                firsts[sex].name = p.name;
                lasts[sex].name = p.name;
                size[sex]++;
            } else if (size[sex] == 1) {
                firsts[sex].next = p;
            }
            else {
                people[sex].next.name = p.name;
                people[sex].next.sex = p.sex;
                people[sex] = people[sex].next;
                lasts[sex] = people[sex];
            }
        }
        lasts[0].next = firsts[0];
        lasts[1].next = firsts[1];
        return new CircleList[]{new CircleList(lasts[0], size[0]), new CircleList(lasts[1], size[1])};
    }
}
