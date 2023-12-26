import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");
        int total = 0;
        int num = 0;
        boolean minus = false;
        for (int i = 0; i < str.length; i++) {
            char ch = str[i].charAt(0);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else {
                if (minus) total -= num;
                else total += num;

                num = 0;
            }
            if (ch == '-') minus = true;
        }
        if (minus) total -= num;
        else total += num;

        System.out.println(total);
    }
}