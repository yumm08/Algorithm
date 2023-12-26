import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] num, prt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        prt = new int[M];
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        combination(0, 0);
    }

    private static void combination(int cnt, int start) {

        if (cnt == M) {
            for (int i = 0; i < M; i++)
                System.out.printf(prt[i] + " ");
            System.out.println("");
            return;
        }
        for (int i = start; i < N; i++) {
            prt[cnt] = num[i];
            combination(cnt + 1, i + 1);
        }
    }
}