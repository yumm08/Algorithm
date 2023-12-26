import java.io.*;
import java.util.*;

public class Main {
	static int N, M, H, day = 0;
	static int[][][] map;
	static Queue<int[]> queue = new ArrayDeque<>();
	static boolean[][][] visit;
	static int[][] del = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		visit = new boolean[N][M][H];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					if (map[i][j][h] == 1) {
						queue.add(new int[] {i, j, h, 0});
						visit[i][j][h] = true;
					}
				}
			}
		}
		checkDate();
		System.out.println(day);
	}

	private static void checkDate() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int l = 0; l < 6; l++) {
				int nx = now[0] + del[l][0];
				int ny = now[1] + del[l][1];
				int nz = now[2] + del[l][2];
				int rank = now[3];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
				if (map[nx][ny][nz] != 0 || visit[nx][ny][nz]) continue;
				
				queue.add(new int[] {nx, ny, nz, rank + 1});
				visit[nx][ny][nz] = true;
				if (day < rank + 1) {
					day = rank + 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int h = 0; h < H; h++) {
					if (map[i][j][h] == 0 && !visit[i][j][h]) {
						day = -1;
						return;
					}
				}
			}
		}
	}

}
