import javax.swing.*;
import java.awt.*;

class DrawingComponentDelete extends JPanel {
    int xg[] = TestDelete.x;
    int yg[] = TestDelete.y;
    int ng = TestDelete.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

public class TestDelete extends JFrame {
    public  static int x[] =  new int[20];
    public  static int y[] = new int[20];
    public static int n = 20;

    public TestDelete () {
        super("Delete test");
        Participant one = new Participant("alla", "asasa", false);
        CircleList testOne = new CircleList("src/testdoc.txt");

        for (int i = 1; i < 21; i++){
            x[i - 1] = i * 20;
        }

        for (int i = 1; i < 21; i++) {

            long start = System.currentTimeMillis();
            testOne.delete("Alex");
            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            y[i - 1] = 300 - (int) (timeConsumedMillis * 10);
            System.out.println(y[i-1]);
            System.out.println(start + " " + finish + " " + timeConsumedMillis);
            for (int j = 0; j < i * 30000; j++) {
                testOne.insert(one);
            }
        }

        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponentDelete(), BorderLayout.CENTER);
        jcp.setBackground(Color.green);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)   {
        new TestDelete().setVisible(true);
    }

}
