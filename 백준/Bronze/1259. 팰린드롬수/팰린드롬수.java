import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] str;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			str = br.readLine().toCharArray();
			if (str[0] == '0')
				break;
			N = str.length;

			if (checkNum(0, N - 1)) {
				System.out.println("yes");
			} else
				System.out.println("no");
		}
	}

	private static boolean checkNum(int x, int y) {
		if (y <= x) {
			return true;
		}

		if (str[x] != str[y]) {
			return false;
		} else {
			return checkNum(x + 1, y - 1);
		}
	}
}
