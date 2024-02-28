import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int N;
    static long maxCost;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] startNode = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));   
            graph.get(to).add(new Node(from, cost));
            startNode[from] = true;   
        }

        maxCost = 0;
        for (int i = 1; i <= N; i++) {
            if (startNode[i]) continue;
            boolean[] visit = new boolean[N + 1];
            visit[i] = true;

            findMaxCost(i, visit, 0);
        }

        System.out.println(maxCost);
    }

    private static void findMaxCost(int now, boolean[] visit, long cost) {
        
        for (Node next : graph.get(now)) {
            if (visit[next.to]) continue;

            visit[next.to] = true;
            findMaxCost(next.to, visit, cost + next.cost);
            visit[next.to] = false;
        }

        if (maxCost < cost) {
            maxCost = cost;
        }
    }
}
