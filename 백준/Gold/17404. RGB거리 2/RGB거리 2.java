import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int color[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dp[][] = new int[N][3];
		int ans = Integer.MAX_VALUE;

		for (int c = 0; c < 3; c++) {
			for (int i = 0; i < 3; i++) {
				if (i == c) {
					dp[0][i] = color[0][i];
				} else {
					dp[0][i] = 1000 * 1000;
				}
			}

			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
			}

			for (int i = 0; i < 3; i++) {
				if (c == i)
					continue;
				ans = Math.min(ans, dp[N - 1][i]);
			}
		}

		System.out.println(ans);
	}
}