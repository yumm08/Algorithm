import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int times = 0; times < T; times++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int k = Integer.parseInt(br.readLine());

			long[] dp = new long[10001];
			dp[0] = 1;

			for (int i = 0; i < n; i++) {
				for (int j = arr[i]; j <= k; j++) {
					dp[j] += dp[j - arr[i]];
				}
			}

			sb.append(dp[k]).append("\n");
		}

		System.out.println(sb);
	}
}
