import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		boolean[] visit = new boolean[N + 1];
		int[] parent = new int[N + 1];
		for (int i = 0; i < N - 1; i++) {
			 st = new StringTokenizer(br.readLine());
			 int from = Integer.parseInt(st.nextToken());
			 int to = Integer.parseInt(st.nextToken());
			 
			 graph.get(from).add(to);
			 graph.get(to).add(from);
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for (int node : graph.get(now)) {
				if (visit[node]) continue;
				
				parent[node] = now;
				visit[node] = true;
				queue.add(node);
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
}
