public class String3 {
    public static void main(String[] args) {

        long start, end;
        int a = 45;
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("k000a   r   a   n");
        }
        end = System.nanoTime();
        System.out.println(end - start);
    }
}
