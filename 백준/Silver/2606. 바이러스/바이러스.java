import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean visit[];
    static int edges[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visit = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        edges = new int[M][2];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 0; i < graph.get(idx).size(); i++) {
                int next = graph.get(idx).get(i);
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    ans++;
                }
            }
        }
        return ans;
    }
}