import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int from;
		int to;
		double cost;

		public Node(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.cost - o.cost);
		}
	}

	static int N, V;
	static double point[][];
	static int[] parents;
	static ArrayList<Node> dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		point = new double[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Double.parseDouble(st.nextToken());
			point[i][1] = Double.parseDouble(st.nextToken());
		}

		V = N * (N + 1) / 2 + 1;
		parents = new int[V];
		dist = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double tempDist = Math.pow(Math.abs(point[i][0] - point[j][0]), 2);
				tempDist += Math.pow(Math.abs(point[i][1] - point[j][1]), 2);
				tempDist = Math.sqrt(tempDist);

				dist.add(new Node(i, j, tempDist));
			}
		}

		Collections.sort(dist);

		make();

		double sum = 0;
		int cnt = 0;

		for (Node n : dist) {
			if (union(n.from, n.to)) {
				sum += n.cost;
				cnt++;

				if (cnt == N - 1) {
					break;
				}
			}
		}

		System.out.printf("%.2f", sum);
	}

	private static boolean union(int from, int to) {

		int fromRoot = findSet(from);
		int toRoot = findSet(to);

		if (fromRoot == toRoot)
			return false;
		else
			parents[toRoot] = fromRoot;
		return true;
	}

	private static int findSet(int v) {

		if (parents[v] == v)
			return v;
		else
			return parents[v] = findSet(parents[v]);
	}

	private static void make() {
		for (int i = 1; i < V; i++) {
			parents[i] = i;
		}
	}
}
