import javax.swing.*;
import java.awt.*;

class DrawingComponentLast extends JPanel {
    int xg[] = TestLast.x;
    int yg[] = TestLast.y;
    int ng = TestLast.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

public class TestLast extends JFrame{
    public  static int x[] =  new int[20];
    public  static int y[] = new int[20];
    public static int n = 20;

    public TestLast () {
        super("Last test");
        Participant one = new Participant("alla", "asasa", false);
        CircleList testOne = new CircleList("src/testdoc.txt");

        for (int i = 1; i < 21; i++){
            x[i - 1] = i * 20;
        }

        for (int i = 1; i < 21; i++) {
            long start = System.currentTimeMillis();
            Participant two = testOne.last(10);
            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            y[i - 1] = 300 - (int) ((timeConsumedMillis) / 2);
            System.out.println(start + " " + finish + " " + timeConsumedMillis);
            testOne = new CircleList("src/testdoc.txt");
            for (int j = 0; j < i * 100000; j++){
                testOne.insert(one);
            }
        }

        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponentLast(), BorderLayout.CENTER);
        jcp.setBackground(Color.green);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)   {
        new TestLast().setVisible(true);
    }
}
