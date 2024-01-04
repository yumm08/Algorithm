import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            super();
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<Node> graph;
    static int[] parents;
    static int N, M;
    static int minCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(from, to, cost));
        }
    
        Collections.sort(graph);
        make();

        findMininum();
        System.out.println(minCost);
    }

    private static void findMininum() {

        int cnt = 0;

        for (Node n : graph) {
            if (union(n.from, n.to)) {
                minCost += n.cost;
                cnt++;

                if (cnt == M - 1) break;
            }
        }
    }

    private static boolean union(int from, int to) {
        from = find(from);
        to = find(to);

        if (from == to) return false;
        else parents[to] = from;
        return true;
    }

    private static int find(int v) {
        if (parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }

    private static void make() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
}