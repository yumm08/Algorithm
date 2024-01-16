import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int F[] = new int[N + 1];

		F[0] = 0;
		F[1] = 1;
		for (int i = 2; i <= N; i++) {
			F[i] = F[i - 1] + F[i - 2];
		}
		System.out.println(F[N]);
	}
}
