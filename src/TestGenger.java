import javax.swing.*;
import java.awt.*;

class DrawingComponentGender extends JPanel {
    int xg[] = TestGenger.x;
    int yg[] = TestGenger.y;
    int ng = TestGenger.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

public class TestGenger extends JFrame{
    public  static int x[] =  new int[20];
    public  static int y[] = new int[20];
    public static int n = 20;

    public TestGenger () {
        super("Genger test");
        Participant one = new Participant("alla", "Yasasa", false);
        Participant two = new Participant("NoAlla", "Dasaasa", true);
        CircleList testOne = new CircleList();

        for (int i = 0; i < 1000; i++){
            testOne.insert(one);
            testOne.insert(two);
        }

        for (int i = 1; i < 21; i++){
            x[i - 1] = i * 20;
        }

        for (int i = 1; i < 21; i++) {
            long start = System.currentTimeMillis();
            testOne.gender();
            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            y[i - 1] = 250 - (int) (timeConsumedMillis * 10);
            System.out.println(start + " " + finish + " " + timeConsumedMillis);
            for (int j = 0; j < 1000; j++){
                testOne.insert(one);
                testOne.insert(two);
            }
        }

        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponentGender(), BorderLayout.CENTER);
        jcp.setBackground(Color.green);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)   {
        new TestGenger().setVisible(true);
    }
}
