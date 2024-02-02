import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 99999999;
	static int N, M;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = INF;
				if (i == j)
					map[i][j] = 0;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a - 1][b - 1] = 1;
			map[b - 1][a - 1] = 1;
		}

		int min = AllPairsShortest();
		System.out.println(min + 1);
	}

	private static int AllPairsShortest() {
		int min = Integer.MAX_VALUE;

		for (int k = 0; k < N; k++) {
			int dist = 0;
			for (int i = 0; i < N; i++) {
				if (i == k)
					continue;

				for (int j = 0; j < N; j++) {
					if (j == k || i == j)
						continue;
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}

		int[] dist = new int[N];
		int min_index = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				dist[i] += map[i][j];
			}

			if (min > dist[i]) {
				min = dist[i];
				min_index = i;
			}
		}

		return min_index;
	}
}