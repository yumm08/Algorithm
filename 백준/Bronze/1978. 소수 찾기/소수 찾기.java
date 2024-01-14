import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] prime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		prime = new boolean[1001];
		N = Integer.parseInt(br.readLine());

		findPrime();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!prime[num]) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static void findPrime() {
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i < 1001; i++) {
			if (prime[i]) {
				continue;
			}

			for (int j = i * 2; j < 1001; j += i) {
				prime[j] = true;
			}
		}
	}
}
