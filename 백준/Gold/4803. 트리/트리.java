import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visit;
	static int n, m, idx;
	static int vertexCnt, edgeCnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		idx = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			visit = new boolean[n + 1];
			graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph.get(from).add(to);
				graph.get(to).add(from);
			}

			idx++;
			int treeCnt = 0;
			for (int i = 1; i <= n; i++) {
				if (visit[i])
					continue;
				vertexCnt = 0;
				edgeCnt = 0;
				dfs(i);

				if (edgeCnt == (vertexCnt - 1) * 2)
					treeCnt++;
			}

			sb.append("Case ").append(idx).append(": ");
			if (treeCnt == 0)
				sb.append("No trees.");
			else if (treeCnt == 1)
				sb.append("There is one tree.");
			else
				sb.append("A forest of ").append(treeCnt).append(" trees.");
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int x) {
		vertexCnt++;
		edgeCnt += graph.get(x).size();

		visit[x] = true;
		for (int y : graph.get(x)) {
			if (visit[y])
				continue;
			dfs(y);
		}
	}

}
