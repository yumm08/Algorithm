import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, R;
    static ArrayList<int[]> bridge;
    static ArrayList<int[]> cow;
    static int[][] visit;
    static int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        bridge = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bridge.add(new int[] {x1 - 1, y1 - 1, x2 - 1, y2 - 1});
            bridge.add(new int[] {x2 - 1, y2 - 1, x1 - 1, y1 - 1});
        }

        cow = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cow.add(new int[] {x - 1, y - 1});
        }

        visit = new int[N][N];
        for (int i = 0; i < cow.size(); i++) {
            if (visit[cow.get(i)[0]][cow.get(i)[1]] == 0) {
                findCow(cow.get(i)[0], cow.get(i)[1], i + 1);
            }
        }
            
        for (int i = 0; i < cow.size() - 1; i++) {
            for (int j = i + 1; j < cow.size(); j++) {
                if (visit[cow.get(i)[0]][cow.get(i)[1]] != visit[cow.get(j)[0]][cow.get(j)[1]]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void findCow(int x, int y, int area) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visit[x][y] = area;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int l = 0; l < 4; l++) {
                int nx = now[0] + del[l][0];
                int ny = now[1] + del[l][1];

                if (!in_range(nx, ny) || visit[nx][ny] == area) {
                    continue;
                }

                boolean check = false;
                for (int[] next : bridge) {
                    if (next[0] == now[0] && next[1] == now[1] && next[2] == nx && next[3] == ny) {
                        check = true;
                    }
                }
                if (check) continue;

                queue.add(new int[] {nx, ny});
                visit[nx][ny] = area;
            }
        }

    }

    private static boolean in_range(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
