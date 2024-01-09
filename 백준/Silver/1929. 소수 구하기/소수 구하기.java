import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M + 1];

		for (int i = 2; i <= M; i++) {
			if (arr[i] == 0) {
				checkPrime(i, M);
				if (i >= N)
					System.out.println(i);
			}
		}

	}

	private static void checkPrime(int num, int end) {
		for (int i = 2; num * i <= end; i++) {
			arr[num * i] = 1;
		}
	}
}
