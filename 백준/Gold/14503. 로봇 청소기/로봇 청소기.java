import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int roomCnt;
    static int r, c, d;
    static int[][] del = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서 -> 북 서 남 동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roomCnt = 1;
        int cnt = 0;
        cleanRoom(r, c, d);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) cnt++;
            }
        }
        // System.out.println(cnt);
        System.out.println(roomCnt);
    }

    private static void cleanRoom(int r, int c, int d) {
        // System.out.println(r + " " + c);
        map[r][c] = -1; // 현재 칸 청소

        if (!checkEmpty(r, c)) { // 만약 청소 할 칸이 없으면
            int nr = r + del[(d + 2) % 4][0]; // 뒤로 한 칸 후진
            int nc = c + del[(d + 2) % 4][1];
            
            if (isAvail(nr, nc) && map[nr][nc] != 1) {
                cleanRoom(nr, nc, d);
            }
        } else { // 청소할 칸이 있으면
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + del[d][0];
                int nc = c + del[d][1];

                if (isAvail(nr, nc) && map[nr][nc] == 0) {
                    cleanRoom(nr, nc, d);
                    roomCnt++;

                    break;
                }
            }
        }
    }

    private static boolean checkEmpty(int r, int c) {
        
        for (int i = 0; i < 4; i++) {
            int nx = r + del[i][0];
            int ny = c + del[i][1];

            if (isAvail(nx, ny) && map[nx][ny] == 0) return true;
        }

        return false;
    }

    private static boolean isAvail(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < N) && (y < M);
    }
} 