import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M, ans;
	static int map[][], cnt;
	static int bridge[][];
	static int del[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {			
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findIsland();
		findBridge();
		findShortestDist();
		if (ans != 0) System.out.println(ans);
		else System.out.println(-1);
	}

	private static void findShortestDist() {
		boolean[] visit = new boolean[cnt + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i <= cnt; i++) {
			if (bridge[1][i] != 0) {
				pq.add(new Node(i, bridge[1][i]));
			}
		}
		visit[1] = true;
		
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int to = n.to;
			int dist = n.cost;
			
			if (visit[to]) continue;
			visit[to] = true;
			ans += dist;
			
			for (int i = 1; i <= cnt; i++) {
				if (visit[i]) continue;
				
				if (bridge[to][i] == 0) continue;
				pq.add(new Node(i, bridge[to][i]));
			}
		}
		
		for (int i = 1; i <= cnt; i++) {
			if (!visit[i]) {
				ans = 0;
				break;
			}
		}
		
	}

	private static void findBridge() {
		bridge = new int[cnt + 1][cnt + 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) continue;
				
				for (int k = 0; k < 4; k++) {
					for (int l = 1; ; l++) {
						int nx = i + del[k][0] * l;
						int ny = j + del[k][1] * l;
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == map[i][j]) break;
						if (map[nx][ny] == 0) continue;
						
						int to = map[i][j];
						int from = map[nx][ny];
						int dist = Math.abs(nx - i) + Math.abs(ny - j) - 1;
						if (dist < 2) break;
						
						if (bridge[from][to] == 0 || bridge[from][to] >= dist) {
							bridge[from][to] = dist;
							bridge[to][from] = dist;
							//System.out.println(from + " " + to + " " + bridge[from][to]);
						}
						
						break;
					}
				}
			}
		}
	}

	private static void findIsland() {
		boolean visit[][] = new boolean[N][M];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] {i, j});
					map[i][j] = ++cnt;
					while (!queue.isEmpty()) {
						int target[] = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nx = target[0] + del[k][0];
							int ny = target[1] + del[k][1];
							if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							if (visit[nx][ny] || map[nx][ny] == 0) continue;
							
							visit[nx][ny] = true;
							queue.add(new int[] {nx, ny});
							map[nx][ny] = cnt;
						}
					}
				} else {
					visit[i][j] = true;
				}
				
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}
