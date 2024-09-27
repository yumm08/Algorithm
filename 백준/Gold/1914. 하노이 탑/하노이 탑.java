import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger res = new BigInteger("1");
		int N = Integer.parseInt(br.readLine());

		if (N <= 20) {
			hanoi(N, 1, 2, 3);
			sb.insert(0, (int) (Math.pow(2, N) - 1) + "\n");
			System.out.print(sb);
		} else {
			for (int i = 0; i < N; ++i) {
				res = res.multiply(new BigInteger("2"));
			}
			res = res.subtract(new BigInteger("1"));
			System.out.println(res);
		}
	}

	public static void hanoi(int num, int from, int by, int to) {
		if (num == 1) {
			sb.append(from + " " + to + "\n");
		} else {
			hanoi(num - 1, from, to, by);
			sb.append(from + " " + to + "\n");
			hanoi(num - 1, by, from, to); 
		}
	}
}
