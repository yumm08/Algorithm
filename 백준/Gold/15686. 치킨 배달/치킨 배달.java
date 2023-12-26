import java.io.*;
import java.util.*;

public class Main {
	static int N, M, minDist = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<int[]> store = new ArrayList<>();
	static ArrayList<int[]> home = new ArrayList<>();
	
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
				if (map[i][j] == 2) store.add(new int[] {i, j});
				else if (map[i][j] == 1) home.add(new int[] {i, j});
			}
		}
		
		selectStore(0, 0, store.size(), new int[M][2]);
		System.out.println(minDist);
	}

	private static void selectStore(int cnt, int index, int K, int[][] order) {
		if (cnt == M) {
			countDist(order);
			return;
		}
		
		for (int i = index; i < K; i++) {
			order[cnt] = store.get(i);
			selectStore(cnt + 1, i + 1, K, order);
		}
	}

	private static void countDist(int[][] order) {
		int totalDist = 0;
		
		for (int[] now : home) {
			int min_dist = Integer.MAX_VALUE;
			for (int[] s : order) {
				int dist = Math.abs(s[0] - now[0]) + Math.abs(s[1] - now[1]);
				if (dist < min_dist) min_dist = dist;
			}
			
			totalDist += min_dist;
			if (totalDist > minDist) return;
		}
		
		if (totalDist < minDist) minDist = totalDist;
	}

}
