import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int count = checkCountOrder(r, c, N);
        System.out.println(count);
    }

    private static int checkCountOrder(int r, int c, int N) {
        if (N == 1) {
            if (r == 1 && c == 1) return 3;
            else if (r == 1) return 2;
            else if (c == 1) return 1;
            else return 0;
        }

        int quart = (int)Math.pow(2, N) / 2;
        if (r >= quart) {
            if (c >= quart) 
                return checkCountOrder(r - quart, c - quart, N - 1) + (int)Math.pow(quart / 2, 2) * 4 * 3;
            else return checkCountOrder(r - quart, c, N - 1) + (int)Math.pow(quart / 2, 2) * 4 * 2;
        } else {
            if (c >= quart) 
                return checkCountOrder(r, c - quart, N - 1) + (int)Math.pow(quart / 2, 2) * 4;
            else return checkCountOrder(r, c, N - 1);
        }
    }
}