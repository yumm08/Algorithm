import java.io.*;
import java.util.Arrays;
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
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
            combination(cnt + 1, i);
        }
    }
}