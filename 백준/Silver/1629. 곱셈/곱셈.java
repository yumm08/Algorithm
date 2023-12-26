import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long ans = fpow(A, B);
		System.out.println(ans % C);
	}

	private static long fpow(int A, int B) {
		if (A == 1 || B == 0) return 1;
		if (B == 1) return A;
		else {
			long n = fpow(A, B / 2);
			if (B % 2 == 0) return (n * n) % C;
			else return (((n * n) % C) * A) % C;
		}
	}

}