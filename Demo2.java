import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo2 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream("C:\\Users\\ACER\\v\\RDEC_JAVA_C\\temp .txt");
 
        out.println("ghjk");

        out.close();

    }
}
