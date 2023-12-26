import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean visit[] = new boolean[26];
    static char map[][];
    static int del[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int R, C;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        int start = map[0][0] - 'A';
        visit[start] = true;
        findMaxAlphabet(0, 0, 1);
        System.out.println(max);
    }

    private static void findMaxAlphabet(int r, int c, int cnt) {

        for (int i = 0; i < 4; i++) {
            int nr = r + del[i][0];
            int nc = c + del[i][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            int index = map[nr][nc] - 'A';
            if (visit[index]) continue;
            visit[index] = true;
            findMaxAlphabet(nr, nc, cnt + 1);
            visit[index] = false;
        }

        max = Math.max(max, cnt);
        return;
    }
}