public class String2 {
    public static void main(String[] args) {
        // String name = "karan";
        // System.out.println(name);
        // name = name + " gupta";
        // String name2 = "karan Gupta";
        // System.out.println(name == name2);
        // // // String name2 = new String("karan"); //Heap
        // // String name2 = new String("karan").intern(); //Pool
        // // // String name2 = "Karan";

        // // System.out.println(name == name2);

        String name = "Ayush"; //65
        String name2 = new String("Yash"); //89
        // System.out.println(name == name2);
        System.out.println(name.equals(name2));
        System.out.println(name2.compareTo(name));
    }
}
