import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int calc[][];
    static int map[][];
    static int tempMap[][];
    static int minRow = Integer.MAX_VALUE;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tempMap = copyMap(map);

        calc = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            calc[i][0] = Integer.parseInt(st.nextToken());
            calc[i][1] = Integer.parseInt(st.nextToken());
            calc[i][2] = Integer.parseInt(st.nextToken());
        }

        perm(0, new int[K], new boolean[K]);
        System.out.println(minRow);
    }

    private static void perm(int cnt, int[] order, boolean[] visit) {
        if (cnt == K) {
            curlByOrder(order);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            order[cnt] = i;
            perm(cnt + 1, order, visit);
            visit[i] = false;
        }
    }

    private static void curlByOrder(int[] arr) {

        for (int i : arr) {
            curlClockwise(calc[i][0] - 1, calc[i][1] - 1, calc[i][2]);

            // for (int x = 0; x < N; x++) {
            //     for (int y = 0; y < M; y++)
            //         System.out.printf("%d ", map[x][y]);
            //     System.out.println();
            // }
        }
        checkMinRow(tempMap);
        tempMap = copyMap(map);
    }

    private static void curlClockwise(int r, int c, int s) {
        int temp[][] = copyMap(tempMap);

        for (int t = 1; t <= s; t++) {
            for (int i = r - t; i <= r + t; i += 2 * t) {
                for (int j = c - t; j <= c + t; j++) {
                    if (i == r - t && j < c + t)
                        temp[i][j + 1] = tempMap[i][j];
                    else if (i == r + t && j > c - t)
                        temp[i][j - 1] = tempMap[i][j];
                }
            }

            for (int j = c - t; j <= c + t; j += 2 * t) {
                for (int i = r - t; i <= r + t; i++) {
                    if (j == c + t && i < r + t)
                        temp[i + 1][j] = tempMap[i][j];
                    else if (j == c - t && i > r - t)
                        temp[i - 1][j] = tempMap[i][j];
                }
            }
        }
        tempMap = copyMap(temp);
    }

    public static int[][] copyMap(int[][] arr) {
        int[][] tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        return tmp;
    }

    private static void checkMinRow(int[][] arr) {

        for (int i = 0; i < N; i++) {
            int total = 0;
            for (int j = 0; j < M; j++)
                total += arr[i][j];

            if (minRow > total)
                minRow = total;
        }
    }
}