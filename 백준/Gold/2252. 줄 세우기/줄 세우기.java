import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder prt = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> q;
    static int degree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        degree = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int times = 0; times < M; times++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            graph.get(prev).add(next);
            degree[next]++;
        }

        q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            prt.append(node).append(" ");
            
            for (int next : graph.get(node)) {
                degree[next]--;
                if (degree[next] == 0) q.add(next);
            }
        }

        System.out.println(prt);
    }
}