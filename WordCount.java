public class WordCount {
    public static void main(String[] args) {
        String str = "   This  is RDEC     COllege     ";
        str = str.trim();
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                c++;
            }
        }
        System.out.println(c + 1);
    }
}
