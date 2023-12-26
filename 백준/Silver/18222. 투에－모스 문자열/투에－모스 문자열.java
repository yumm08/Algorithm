import java.io.*;

public class Main {
    static long k;
    static int ch = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Long.parseLong(br.readLine());

        findRange(0, 60);
    }

    private static void findRange(int start, int end) {
        if (end == 1) {
            findAnswer(0);
            return;
        }
        if (end - start == 1) {
            k = k - (long)Math.pow(2, start);
            //System.out.println(k);
            ch++;
            findRange(0,start);
            return;
        }

        int temp = (end + start) / 2;
        //System.out.println(temp);
        if (Math.pow(2, temp) < k) findRange(temp, end);
        else if (Math.pow(2, temp) > k) findRange(start, temp);
        else if (Math.pow(2, temp) == k) findAnswer(temp);
    }

    private static void findAnswer(int start) {
        
        int ans = start + ch;

        if (ans % 2 == 1) System.out.println(1);
        else System.out.println(0);
    }
}