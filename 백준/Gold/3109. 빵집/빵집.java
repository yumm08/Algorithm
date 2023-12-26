import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int del[][] = {  { -1, 1 }, { 0, 1 }, { 1, 1 }};
    static int count = 0;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = str[j].charAt(0);
            }
        }

        for (int i = 0; i < R; i++) {
            checkValidPipeline(i, 0);
        }
        System.out.println(count);
    }

    private static boolean checkValidPipeline(int x, int y) {
        visit[x][y] = true;
        if (y == C - 1) {
            count++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = del[i][0] + x;
            int ny = del[i][1] + y;
            if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                continue;
            if (!visit[nx][ny] && map[nx][ny] != 'x') {
                if (checkValidPipeline(nx, ny)) return true;
            }
        }
        return false;
    }
}