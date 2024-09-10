import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int ans;
	static int del[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] || map[i][j] == 0) {
					continue;
				}

				flag = true;
				findPeak(i, j);
				if (flag)
					ans++;
			}
		}

		System.out.println(ans);
	}

	private static void findPeak(int x, int y) {
		for (int l = 0; l < 8; l++) {
			int nx = x + del[l][0];
			int ny = y + del[l][1];

			if (!inRange(nx, ny)) {
				continue;
			}

			if (map[x][y] < map[nx][ny]) {
				flag = false;
			}

			if (map[x][y] == map[nx][ny] && !visit[nx][ny]) {
				visit[nx][ny] = true;
				findPeak(nx, ny);
			}
		}

	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}
}
