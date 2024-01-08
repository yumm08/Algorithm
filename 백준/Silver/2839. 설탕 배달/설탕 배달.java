import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		while (N % 5 != 0 && N >= 0) {
			N -= 3;
			ans++;
		}

		if (N % 5 == 0) {
			System.out.println(N / 5 + ans);
		} else
			System.out.println(-1);
	}
}
