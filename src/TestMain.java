import java.io.FileWriter;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args){

        System.out.println("Its working!!!");
        CircleList test1 = new CircleList("src/testdoc.txt");
        test1.show();
        test1.sort("alex");
        test1.show();
        Participant one = new Participant("alla", "asasa", false);
        test1.insert(one);
        test1.show();
        test1.sort("dan");
        test1.show();
        test1.delete("alla");
        test1.show();
        CircleList[] arr = test1.gender();
        arr[0].show();



    }

}
