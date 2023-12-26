import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, T, maxArea = Integer.MIN_VALUE;
    static TreeSet<Integer> set = new TreeSet<>();
    static int[][] del = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                set.add(map[i][j]);
            }
        }

        int temp = set.first();
        if (temp >= 2)
            set.add(temp - 1);
        set.add(0);
        temp = set.last();
        if (temp != 100)
            set.add(temp + 1);

        while (!set.isEmpty()) {
            visit = new boolean[N][N];
            T = set.first();
            checkArea();
            set.remove(T);
        }

        System.out.println(maxArea);
    }

    public static void checkArea() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > T && !visit[i][j]) {
                    findArea(i, j);
                    cnt++;
                }
            }
        }

        if (maxArea < cnt) {
            maxArea = cnt;
        }
    }

    public static void findArea(int x, int y) {
        visit[x][y] = true;

        for (int l = 0; l < 4; l++) {
            int nr = x + del[l][0];
            int nc = y + del[l][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;
            if (map[nr][nc] <= T || visit[nr][nc])
                continue;

            visit[nr][nc] = true;
            findArea(nr, nc);
        }
    }
}