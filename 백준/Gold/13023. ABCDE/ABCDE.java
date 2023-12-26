import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int valid;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++)
            findFriends(i, 1, new boolean[N+1]);

        System.out.println(valid);
    }

    private static void findFriends(int v, int count, boolean visit[]) {
        if (count == 5) {
            valid = 1;
            return;
        }
        if (valid == 1) return;

        visit[v] = true;
        for (int node : graph.get(v)) {
            if (!visit[node]) {
                findFriends(node, count + 1, visit);
            }
        }
        visit[v] = false;
    }
}