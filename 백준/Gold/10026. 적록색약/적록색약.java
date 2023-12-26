import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder prt = new StringBuilder();
    static Queue<int[]> q;
    static int N;
    static char[][] map;
    static char[][] mapC;
    static boolean visit[][];
    static int[][] del = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        mapC = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                
                if (map[i][j] == 'R') mapC[i][j] = 'G';
                else mapC[i][j] = map[i][j];
            }
        }


        findSpaceNum(map);
        findSpaceNum(mapC);
        System.out.println(prt);
    }

    private static void findSpaceNum(char[][] arr) {
        int count = 0;

        q = new LinkedList<>();
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;

                q.add(new int[]{i, j});
                count++;
                while (!q.isEmpty()) {
                    int node[] = q.poll();
                    char color = arr[node[0]][node[1]];

                    for (int k = 0; k < 4; k++) {
                        int nr = node[0] + del[k][0];
                        int nc = node[1] + del[k][1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (visit[nr][nc]) continue;
                        if (arr[nr][nc] != color) continue;

                        visit[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        prt.append(count).append(" ");
    }
}