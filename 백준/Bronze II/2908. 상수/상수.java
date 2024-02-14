import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		System.out.println(Math.max(rev(X), rev(Y)));
	}

	private static int rev(int num) {
		int result = 0;

		while (num > 0) {
			result *= 10;
			result += num % 10;
			num /= 10;
		}

		return result;
	}
}
