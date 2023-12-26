import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visit;
	static int count;
	static int[][] del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int times = 1; times <= T; times++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[b][a] = 1;
			}
			
			visit = new boolean[N][M];
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						count++;
						findCabbage(i, j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void findCabbage(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visit[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int l = 0; l < 4; l++) {
				int nr = now[0] + del[l][0];
				int nc = now[1] + del[l][1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visit[nr][nc] || map[nr][nc] == 0) continue;
				
				queue.add(new int[] {nr, nc});
				visit[nr][nc] = true;
			}
		}
	}
}
