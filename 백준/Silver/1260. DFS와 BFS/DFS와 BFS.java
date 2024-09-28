import java.io.*;
import java.util.*;

public class Main {

	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visitBFS[];
	static boolean visitDFS[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph.get(from).add(to);
			graph.get(to).add(from);
		}

		for (int i = 0; i <= N; i++) {
			graph.get(i).sort(null);
		}

		visitDFS = new boolean[N + 1];
		dfs(V);
		System.out.println();
		visitBFS = new boolean[N + 1];
		bfs(V);
	}

	private static void dfs(int now) {

		visitDFS[now] = true;
		System.out.print(now + " ");

		for (int node : graph.get(now)) {
			if (!visitDFS[node]) {
				visitDFS[node] = true;
				dfs(node);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visitBFS[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");

			for (int node : graph.get(now)) {
				if (!visitBFS[node]) {
					visitBFS[node] = true;
					queue.add(node);
				}
			}
		}

	}
}
