import java.io.*;

public class Main {
	static int N, cnt;
	static int[][] map;
	static boolean[] visit;
	static int[][] del = {{-1, 1}, {-1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		
		cnt = 0;
		findLocations(0);
		System.out.println(cnt);
	}

	private static void findLocations(int now) {
		if (now == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visit[i] || !checkValid(now, i)) {
				continue;
			} 
			map[now][i] = 1;
			visit[i] = true;
			findLocations(now + 1);
			map[now][i] = 0;
			visit[i] = false;
		}
	}

	private static boolean checkValid(int x, int y) {

		for (int l = 0; l < 2; l++) {
			for (int t = 1; ; t++) {
				int nx = x + del[l][0] * t;
				int ny = y + del[l][1] * t;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
				if (map[nx][ny] == 1) return false;
			}
		}
	
		return true;
	}

}
