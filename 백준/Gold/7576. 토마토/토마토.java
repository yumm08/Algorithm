import java.io.*;
import java.util.*;

public class Main {
	static int N, M, day = 0;
	static int[][] map;
	static Queue<int[]> queue = new ArrayDeque<>();
	static boolean[][] visit;
	static int[][] del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.add(new int[] {i, j, 0});
					visit[i][j] = true;
				}
			}
		}
		
		checkDate();
		System.out.println(day);
	}

	private static void checkDate() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int l = 0; l < 4; l++) {
				int nr = now[0] + del[l][0];
				int nc = now[1] + del[l][1];
				int rank = now[2];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] != 0 || visit[nr][nc]) continue;
				
				queue.add(new int[] {nr, nc, rank + 1});
				visit[nr][nc] = true;
				if (day < rank + 1) {
					day = rank + 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					day = -1;
					return;
				}
			}
		}
	}

}
