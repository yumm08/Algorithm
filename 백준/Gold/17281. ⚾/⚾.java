import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int[][] player;
    static int N;
    static int maxScore = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        player = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[9];
        perm(0, new int[9]);
        System.out.println(maxScore);
    }

    private static void perm(int cnt, int[] order) {
        if (cnt == 9) {
            calcScore(order);
            return;
        }

        if (cnt == 3) {
            order[cnt] = 0;
            perm(cnt + 1, order);
            return;
        }

        for (int i = 1; i <= 8; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            order[cnt] = i;
            perm(cnt + 1, order);
            visit[i] = false;
        }
    }

    private static void calcScore(int[] order) {
        int index = 0;
        int total = 0;

        for (int t = 0; t < N; t++) {
            int result[] = new int[3];
            int out = 0;
            while (out != 3) {
                int now = order[index];

                if (player[t][now] == 4) {
                    for (int i = 0; i < 3; i++) {
                        total += result[i];
                        result[i] = 0;
                    }
                    total++;
                } else if (player[t][now] == 3) {
                    for (int i = 0; i < 3; i++) {
                        total += result[i];
                        result[i] = 0;
                    }
                    result[2]++;
                } else if (player[t][now] == 2) {
                    for (int i = 2; i >= 0; i--) {
                        if (i >= 1) {
                            total += result[i];
                            result[i] = 0;
                        } else {
                            result[i+2] = result[i];
                            result[i] = 0;
                        }
                    }
                    result[1]++;
                } else if (player[t][now] == 1) {
                    for (int i = 2; i >= 0; i--) {
                        if (i >= 2) {
                            total += result[i];
                            result[i] = 0;
                        } else {
                            result[i+1] = result[i];
                            result[i] = 0;
                        }
                    }
                    result[0]++;
                } else {
                    out++;
                }

                index = (++index) % 9;
            }
        }

        maxScore = Math.max(maxScore, total);
    }
}