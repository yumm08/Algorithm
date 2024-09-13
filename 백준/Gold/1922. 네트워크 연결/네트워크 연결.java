import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[][] graph;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		graph = new int[E][3];
		parent = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		long result = 0;
		int count = 0;
		for (int[] node : graph) {
			if (union(node[0], node[1])) {
				result += node[2];
				if (++count == V - 1)
					break;
			}
		}

		System.out.println(result);
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parent[bRoot] = aRoot;
		return true;

	}
}