import java.io.*;
import java.util.*;

public class Main {
	static int N, M, rank;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String arr = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr.charAt(j) - '0';
			}
		}
		
		visit = new boolean[N][M];
		findMinimumRoute();
		System.out.println(rank);
	}

	private static void findMinimumRoute() {
		int del[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0, 1});
		visit[0][0] = true;
		
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			if (now[0] == N - 1 && now[1] == M - 1) {
				rank = now[2];
				break;
			}
			
			for (int l = 0; l < 4; l++) {
				int nr = now[0] + del[l][0];
				int nc = now[1] + del[l][1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 0 || visit[nr][nc]) continue;
				
				queue.add(new int[] {nr, nc, now[2] + 1});
				visit[nr][nc] = true;
			}
		}
	}

}
