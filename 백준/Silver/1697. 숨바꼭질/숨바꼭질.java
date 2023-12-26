import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q;
    static boolean visit[] = new boolean[100001];
    static int N, K;
    static int minTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        visit[N] = true;
        q.add(N);
        findFastestTime();
        System.out.println(minTime);
    }

    private static void findFastestTime() {
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                if (node == K) {
                    return;
                }

                if (node + 1 <= 100000) {
                    if (!visit[node + 1]) {
                        visit[node + 1] = true;
                        q.add(node + 1);
                    }
                }
                if (node - 1 >= 0) {
                    if (!visit[node - 1]) {
                        visit[node - 1] = true;
                        q.add(node - 1);
                    }
                }
                if (node * 2 <= 100000) {
                    if (!visit[node * 2]) {
                        visit[node * 2] = true;
                        q.add(node * 2);
                    }
                }
            }
            minTime++;
        }
    }
}