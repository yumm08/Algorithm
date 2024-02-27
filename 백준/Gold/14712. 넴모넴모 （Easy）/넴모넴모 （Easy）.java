import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        findAllNemos(new boolean[N][M], 0, 0);
        System.out.println(ans);
    }

    private static void findAllNemos(boolean[][] visit, int x, int y) {
        ans++;

        for (int i = x; i < N; i++) {
            int j = 0;
            if (i == x) j = y;
            for (; j < M; j++) {
                if (visit[i][j]) continue;

                visit[i][j] = true;
                if (!checkNemos(visit)) {
                    findAllNemos(visit, i, j + 1);
                }
                visit[i][j] = false;
            }
        }
    
    }

    private static boolean checkNemos(boolean[][] visit) {
        
        int[][] del = {{0, 1}, {1, 0}, {1, 1}};

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (!visit[i][j]) continue;

                int cnt = 0;

                for (int l = 0; l < 3; l++) {
                    int nx = i + del[l][0];
                    int ny = j + del[l][1];

                    if (visit[nx][ny]) cnt++;
                }

                if (cnt == 3) return true;
            }
        }
    
        return false;
    }
}
