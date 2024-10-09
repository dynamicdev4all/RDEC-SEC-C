import java.util.Scanner;

public class ScannerCountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner("This is RDEC");
        int c = 0;












        
        while (sc.hasNext()) {
            sc.next();
            c++;
        }
        System.out.println(c);
    }
}
