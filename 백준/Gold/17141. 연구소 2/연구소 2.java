import java.io.*;
import java.util.*;

public class Main {

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int N, M, count = 0, answer = Integer.MAX_VALUE;
	private static int[][] map;
	private static boolean[] check;
	private static List<Node> virus = new ArrayList<>();
	private static final int[] dx = { 0, 0, -1, 1 };
	private static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Node(j, i));
				if (map[i][j] == 0)
					count++;
			}
		}

		count += virus.size() - M;
		check = new boolean[virus.size()];

		if (count == 0)
			answer = 0;
		else
			combination(0, 0);

		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void combination(int depth, int start) {
		if (depth == M) {
			int[][] copyMap = copy();
			bfs(copyMap, count);
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			check[i] = true;
			combination(depth + 1, i + 1);
			check[i] = false;
		}
	}

	private static void bfs(int[][] map, int count) {
		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < virus.size(); i++) {
			if (check[i])
				queue.add(virus.get(i));
		}

		int time = 0;
		while (!queue.isEmpty()) {
			if (answer <= time)
				break;

			int len = queue.size();
			for (int t = 0; t < len; t++) {
				Node now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (map[ny][nx] != 0)
						continue;

					map[ny][nx] = 2;
					queue.add(new Node(nx, ny));
					count--;
				}
			}

			time++;
			if (count == 0) {
				answer = time;
				return;
			}
		}
	}

	private static int[][] copy() {
		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				copyMap[i][j] = (map[i][j] == 2 ? 0 : map[i][j]);
		}

		for (int i = 0; i < virus.size(); i++) {
			if (check[i]) {
				Node node = virus.get(i);
				copyMap[node.y][node.x] = 2;
			}
		}

		return copyMap;
	}
}