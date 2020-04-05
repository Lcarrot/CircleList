import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

class DrawingComponentConstructor extends JPanel {
    int xg[] = TestConstructor.x;
    int yg[] = TestConstructor.y;
    int ng = TestConstructor.n;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

public class TestConstructor extends JFrame{
    public  static int x[] =  new int[20];
    public  static int y[] = new int[20];
    public static int n = 20;

    public TestConstructor () {
        super("Constructor test");
        for (int i = 1; i < 21; i++) {
            x[i - 1] = i * 20;
        }

        for (int i = 1; i < 21; i++) {

            try (FileWriter writer = new FileWriter("src/testdoc.txt")) {
                //коэф домножения i можно увеличивать. Чем выше - тем лучше точность и теплее твой ноутбук.
                for (int j = 0; j < i * 3100; j++) {
                    writer.write("\nLeonid" + " " + "My" + " " + "man");
                }
                writer.flush();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }

            long start = System.currentTimeMillis();
            CircleList testOne = new CircleList("src/testdoc.txt");
            long finish = System.currentTimeMillis();
            testOne.show();
            long timeConsumedMillis = finish - start;
            y[i - 1] = 300 - (int) (timeConsumedMillis * 3);
            System.out.println(start + " " + finish + " " + timeConsumedMillis);
        }

        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponentConstructor(), BorderLayout.CENTER);
        jcp.setBackground(Color.green);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)   {
        new TestConstructor().setVisible(true);
    }
}
