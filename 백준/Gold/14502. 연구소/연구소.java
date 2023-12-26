import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<int[]> graph = new ArrayList<>();
	static ArrayList<int[]> virus = new ArrayList<>();
	static int N, M, minVirus = Integer.MAX_VALUE;
	static int map[][], total = 0;
	static boolean visit[][];

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
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
				else if (map[i][j] == 0) {
					total++;
					graph.add(new int[] { i, j });
				}
			}
		}

		visit = new boolean[N][M];
		selectWall(0, 0, new int[3][2]);
		System.out.println(total - 3 - minVirus);
	}

	private static void selectWall(int cnt, int start, int newWall[][]) {
		if (cnt == 3) {
			countVirus(newWall);
			return;
		}

		for (int i = start; i < graph.size(); i++) {
			int x = graph.get(i)[0];
			int y = graph.get(i)[1];

			if (visit[x][y]) continue;
			visit[x][y] = true;
			newWall[cnt] = new int[] { x, y };
			selectWall(cnt + 1, i + 1, newWall);
			visit[x][y] = false;
		}
	}
	
	private static void countVirus(int[][] newWall) {
		int cnt = 0;
		boolean visited[][] = new boolean[N][M];

		for (int i = 0; i < 3; i++) {
			visited[newWall[i][0]][newWall[i][1]] = true;
		}

		int del[][] = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
		for (int i = 0; i < virus.size(); i++) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(virus.get(i));

			while (!queue.isEmpty()) {
				int index[] = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nx = index[0] + del[j][0];
					int ny = index[1] + del[j][1];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;

					if (map[nx][ny] == 0 && !visited[nx][ny]) {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
						cnt++;
					}
				}

				if (cnt > minVirus)
					break;
			}
		}

		if (cnt < minVirus) {
			minVirus = cnt;
		}
	}
}