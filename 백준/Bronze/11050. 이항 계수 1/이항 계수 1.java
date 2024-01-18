import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int num = multipleN(N, K);
		int ans = num / multipleN(K, K);
		System.out.println(ans);
	}

	private static int multipleN(int n, int k) {
		if (k == 0) {
			return 1;
		}

		return n * multipleN(n - 1, k - 1);
	}
}
