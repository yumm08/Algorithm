import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int k, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int times = 0; times < T; times++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());

			int p[][] = new int[k + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				p[0][i] = i;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					p[i][j] = p[i - 1][j] + p[i][j - 1];
				}
			}

			System.out.println(p[k][n]);
		}

	}
}
