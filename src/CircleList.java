import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author Alexey and Leonid.
 * @version 1.0.1231334356674864768580068918.2001
 */

public class CircleList {

    private Participant lastParticipant;
    private int size;

    public CircleList(Participant lastParticipant, int size) {
        this.lastParticipant = lastParticipant;
        this.size = size;
    }

    public CircleList() {
        size = 0;
        lastParticipant = null;
    }

    public CircleList(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Scanner sc = new Scanner(reader);
            size = 0;
            while (sc.hasNextLine()) {
                insert(Participant.readNewParticipantFromFile(sc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * shows participants in a sheet
     */

    public void show() {
        if (lastParticipant == null) {
            System.out.println("No members listed.");
        }
        else {
            Participant participant = lastParticipant.getNext();
            for (int i = 0; i < size - 1; i++) {
                System.out.print(participant.toString() + ", ");
                participant = participant.getNext();
            }
            System.out.println(participant.toString() + ".");
        }
    }

    /**
     * adds a participant to the list
     * @param participant this participant
     */

    public void insert(Participant participant) {
        if (lastParticipant == null) {
            lastParticipant = initializeNewParticipant(participant);
            lastParticipant.setNext(lastParticipant);
        }
        else {
            Participant participantInList = initializeNewParticipant(participant);
            participantInList.setNext(lastParticipant.getNext());
            lastParticipant.setNext(participantInList);
            lastParticipant = participantInList;
        }
        size++;
    }

    /**
     * кeads a participant instance from a file
     * @param participant
     * @return participant instance
     */

    private Participant initializeNewParticipant(Participant participant) {
        return new Participant(participant.getName(),participant.getSurname(), participant.isSex());
    }

    /**
     * deletes participant by name
     * @param name participant name
     */

    public void delete(String name) {
        Participant participant = lastParticipant;
        for (int i = 0; i < size; i++) {
            if (participant.getNext().getName().equals(name)) {
                participant.setNext(participant.getNext().getNext());
                size--;
            }
            participant = participant.getNext();
        }
    }

    /**
     * sort the source list by participant name
     * @param name participant name
     */

    public void sort(String name) {
        Participant p = lastParticipant;
        for (int i = 0; i < size; i++) {
            if (p.getNext().getName().equals(name)) {
                lastParticipant = p;
                break;
            }
            p = p.getNext();
        }
    }

    /**
     * removes every kth and returns the remaining
     * @param k removal rate
     * @return last participant
     */

    public Participant last(int k) {
        Participant p = lastParticipant;
        while (size > 1) {
            int s = Math.abs(size - k) - 1;
            for (int i = 0; i < s; i++) {
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
            size--;
        }
        return p;
    }

    /**
     * builds two lists of men and women
     * @return arrays of CircleList of men and women
     */

    public CircleList[] gender() {
        CircleList men = new CircleList();
        CircleList women = new CircleList();
        Participant people = lastParticipant.getNext();
        for (int i = 0; i < this.size; i++) {
            if (people.isSex()) {
                men.insert(people);
            } else {
                women.insert(people);
            }
            people = people.getNext();
        }
        return new CircleList[]{men, women};
    }
}
