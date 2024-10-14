import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Date;

public class RBBundle {

    static String printTotal(Locale locale, double num) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(num);
    }

    static String printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dtf.format(date);
    }

    public static void main(String[] args) {
        Locale locale;
        ResourceBundle rb;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please choose your language");
        System.out.println("Press 1 for Hindi, 2 for English and 3 for Japanese");
        int langChoice = sc.nextInt();
        if (langChoice == 1) {
            locale = new Locale("hi", "IN");
        } else if (langChoice == 2) {
            locale = new Locale("en", "US");
        } else if (langChoice == 3) {
            locale = new Locale("jp", "JP");
        } else {
            System.out.println("Invalid Choice, by default now using English");
            locale = new Locale("en", "US");
        }

        rb = ResourceBundle.getBundle("ResourceBundle", locale);

        System.out.println(rb.getString("greet"));

        System.out.println(rb.getString("enterName"));
        // String name = sc.nextLine();
        // System.out.println("Purchased Item name?");
        // String itemName = sc.nextLine();
        // System.out.println("Price?");
        // double totalPaid = sc.nextDouble();
        // System.out.println("Tax in %?");
        // double taxPer = sc.nextDouble();

        // double taxPaid = totalPaid * (taxPer / 100);
        // double netPaid = totalPaid - taxPaid;

        // System.out.println("*****************************");
        // System.out.println("Welcome, " + name);
        // System.out.println("You have bought " + itemName + " on " +
        // printDate(locale));
        // System.out.println("Total Paid " + printTotal(locale, totalPaid));
        // System.out.println("Tax Paid " + printTotal(locale, taxPaid));
        // System.out.println("Net Paid " + printTotal(locale, netPaid));
        // }
    }
}
