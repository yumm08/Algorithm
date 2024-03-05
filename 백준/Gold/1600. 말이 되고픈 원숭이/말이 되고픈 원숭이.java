import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static class Node {
        int x;
        int y;
        int cnt;
        int k;

        public Node(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }

    static int K, W, H;
    static int[][] map;
    static boolean[][][] visit;
    static int moveTime = -1;
    static int[][] horse = {{-1, 2}, {-2, 1}, {2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};
    static int[][] monkey = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[H][W][K + 1];
        bfs();
        System.out.println(moveTime);
    }

    private static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                moveTime = now.cnt;
                return;
            }

            for (int l = 0; l < 4; l++) {
                int nx = now.x + monkey[l][0];
                int ny = now.y + monkey[l][1];

                if (!in_range(nx, ny) || map[nx][ny] == 1 || visit[nx][ny][now.k]) {
                    continue;
                }

                queue.add(new Node(nx, ny, now.cnt + 1, now.k));
                visit[nx][ny][now.k] = true;
            }

            if (now.k < K) {
                for (int l = 0; l < 8; l++) {
                    int nx = now.x + horse[l][0];
                    int ny = now.y + horse[l][1];
    
                    if (!in_range(nx, ny) || map[nx][ny] == 1 || visit[nx][ny][now.k + 1]) {
                        continue;
                    }
    
                    queue.add(new Node(nx, ny, now.cnt + 1, now.k + 1));
                    visit[nx][ny][now.k + 1] = true;
                }
            }
        }
    }

    private static boolean in_range(int x, int y) {
    
        return x >= 0 && y >= 0 && x < H && y < W;
    }
}
