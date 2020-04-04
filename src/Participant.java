import java.util.Scanner;

public class Participant {

    private String name;
    private String surname;
    private boolean sex;
    private Participant next;

    public Participant(String name,String surname, boolean sex) {
        this.name = name;
        this.sex = sex;
        this.surname = surname;
        next = null;
    }

    public boolean isSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setNext(Participant next) {
        this.next = next;
    }

    public Participant getNext() {
        return next;
    }

    public String getSurname() {
        return surname;
    }

    public static Participant readNewParticipantFromFile(Scanner sc) {
        return new Participant(sc.next(),sc.next(), sc.next().equalsIgnoreCase("man"));
    }

    public String toString() {
        return getName()+ ' '+ getSurname();
    }
}
