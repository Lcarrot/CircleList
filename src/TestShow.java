import javax.swing.*;
import java.awt.*;

class DrawingComponentShow extends JPanel {
    int xg[] = TestShow.x;
    int yg[] = TestShow.y;
    int ng = TestShow.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

public class TestShow extends JFrame{
    public  static int x[] =  new int[20];
    public  static int y[] = new int[20];
    public static int n = 20;

    public TestShow () {
        super("Show test");
        Participant one = new Participant("alla", "asasa", false);
        CircleList testOne = new CircleList();
        testOne.insert(one);
        for (int i = 1; i < 21; i++){
            x[i - 1] = i * 20;
        }

        for (int i = 1; i < 21; i++) {
            long start = System.currentTimeMillis();
            testOne.show();
            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            y[i - 1] = 200 - (int) (timeConsumedMillis * 7);
            System.out.println(start + " " + finish + " " + timeConsumedMillis);
            for (int j = 0; j < 500; j++){
                testOne.insert(one);
            }
        }

        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponentShow(), BorderLayout.CENTER);
        jcp.setBackground(Color.green);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)   {
        new TestShow().setVisible(true);
    }
}
