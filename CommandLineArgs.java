public class CommandLineArgs {
    public static void main(String[] args) {
        // int num1 = args[0];
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String opr = args[2];
        if (opr == "+") {
            // int sum = num1 * num2;
            System.out.println(num1 + num2);

        }
        // System.out.println(args[0]);
        // System.out.println(args[1]);
    }
}
