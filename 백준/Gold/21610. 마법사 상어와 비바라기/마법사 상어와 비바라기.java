import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static int del[][] = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
    static int total = 0;
    static ArrayList<int[]> cloud = new ArrayList<>();
    static int N, M;
    static int dir, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        cloud.add(new int[] {N-1,1});
        cloud.add(new int[] {N-1,2});
        cloud.add(new int[] {N,1});
        cloud.add(new int[] {N,2});
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cloud.size(); j++) {
                int xy[] = cloud.get(j);
                xy[0] += del[dir - 1][0] * s;
                xy[1] += del[dir - 1][1] * s;

                for (int t = 0; t < 2; t++) {
                    while (xy[t] < 1)
                        xy[t] = N + xy[t];
                    while (xy[t] > N) {
                        xy[t] = xy[t] - N;
                    }
                }

                int x = xy[0];
                int y = xy[1];
                cloud.set(j, xy);
                map[x][y]++;
                total++;
            }
            makeCloud();
        }
        System.out.println(total);
    }

    private static void makeCloud() {
        for (int c[] : cloud) {
            int cnt = 0;

            for (int i = 1; i < 8; i += 2) {
                int x = c[0] + del[i][0];
                int y = c[1] + del[i][1];
                if (x < 1 || x > N || y < 1 || y > N)
                    continue;
                if (map[x][y] != 0)
                    cnt++;
            }

            map[c[0]][c[1]] += cnt;
            total += cnt;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isCloudSpace(i, j) && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    total -= 2;
                    cloud.add(new int[] {i, j});
                }
            }
        }
    }

    private static boolean isCloudSpace(int x, int y) {

        for (int i = 0; i < cloud.size(); i++) {
            int c[] = cloud.get(i);
            if (c[0] == x && c[1] == y) {
                cloud.remove(i);
                return true;
            }
        }
        return false;
    }
}