import java.io.*;
import java.util.*;

public class Main {
    static int w[][];
    static int N, start;
    static long min = Long.MAX_VALUE;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            start = i;
            findMinimunCost(start, 0, 0, new int[N]);
        }

        System.out.println(min);
    }

    private static void findMinimunCost(int s, int cnt, int total, int city[]) {
        if (cnt == N - 1) { 
            //System.out.println(total + " " + w[s][start] + " " + Arrays.toString(city));
            if (w[s][start] == 0) return;
            min = Math.min(min, total + w[s][start]);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visit[i] || w[s][i] == 0) continue;
            if (total + w[s][i] > min) return;

            visit[i] = true;
            city[cnt] = i;
            findMinimunCost(i, cnt + 1, total + w[s][i], city);
            visit[i] = false;
        }
    }
}
