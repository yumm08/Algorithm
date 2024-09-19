import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, N) - 1).append("\n");
        hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to, int tmp) {
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
   
        hanoi(n - 1, from, tmp, to);
        sb.append(from + " " + to + "\n");
        hanoi(n - 1, tmp, to, from);
    }
}
