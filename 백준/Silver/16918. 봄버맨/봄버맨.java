import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static char[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        char[][] firstBomb = makeBomb(map);
        char[][] secondBomb = makeBomb(firstBomb);
        
        if (N <= 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
        } else {
            if (N % 4 == 3) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(firstBomb[i][j]);
                    }
                    System.out.println();
                }
            } else if (N % 4 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(secondBomb[i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }

    private static char[][] makeBomb(char[][] map) {

        int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        char[][] newMap = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = 'O';
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    newMap[i][j] = '.';

                    for (int l = 0; l < 4; l++) {
                        int nr = i + del[l][0];
                        int nc = j + del[l][1];
                        if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                            continue;
                        }

                        newMap[nr][nc] = '.';
                    }
                }
            }
        }

        return newMap;
    }
}
