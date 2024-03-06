import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int x;
		int y;
		int cnt;
		int sword;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public Node(int x, int y, int cnt, int sword) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.sword = sword;
		}
	}

	static int N, M, T;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] del = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int minTime = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// withoutSword();
		withSword();
		if (minTime == Integer.MAX_VALUE)
			System.out.println("Fail");
		else
			System.out.println(minTime);
	}

	/**
	 * private static void withoutSword() {
	 * 
	 * Queue<Node> queue = new ArrayDeque<>();
	 * queue.add(new Node(0, 0, 0));
	 * visit = new boolean[N][M];
	 * visit[0][0] = true;
	 * 
	 * while (!queue.isEmpty()) {
	 * Node now = queue.poll();
	 * if (now.x == N - 1 && now.y == M - 1) {
	 * minTime = Math.min(minTime, now.cnt);
	 * return;
	 * }
	 * 
	 * if (now.cnt > T) {
	 * return;
	 * }
	 * 
	 * for (int l = 0; l < 4; l++) {
	 * int nx = now.x + del[l][0];
	 * int ny = now.y + del[l][1];
	 * 
	 * if (!in_range(nx, ny) || map[nx][ny] == 1 || visit[nx][ny][now.sword]) {
	 * continue;
	 * }
	 * 
	 * queue.add(new Node(nx, ny, now.cnt + 1));
	 * visit[nx][ny] = true;
	 * }
	 * }
	 * }
	 **/

	private static void withSword() {

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 0, 0));
		visit = new boolean[N][M][2];
		visit[0][0][0] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			// System.out.println(now.x + " " + now.y + " " + now.cnt);

			if (now.cnt > T) {
				return;
			}
			if (now.x == N - 1 && now.y == M - 1) {
				minTime = Math.min(minTime, now.cnt);
				return;
			}

			for (int l = 0; l < 4; l++) {
				int nx = now.x + del[l][0];
				int ny = now.y + del[l][1];

				if (!in_range(nx, ny) || (map[nx][ny] == 1 && now.sword == 0) || visit[nx][ny][now.sword]) {
					continue;
				}
				if (map[nx][ny] == 2) {
					// queue = new ArrayDeque<>();
					queue.add(new Node(nx, ny, now.cnt + 1, 1));
					visit[nx][ny][1] = true;
				} else {
					queue.add(new Node(nx, ny, now.cnt + 1, now.sword));
					visit[nx][ny][now.sword] = true;
				}

			}
		}
	}

	private static boolean in_range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
