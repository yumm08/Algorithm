import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int num = 0;
		for (int i = 1; i <= N; i++) {
			num += check(i);
		}

		System.out.println(num);
	}

	private static int check(int num) {

		if (num < 10)
			return 1;

		int d = num % 10 - num / 10 % 10;

		while (num >= 10) {
			int a = num % 10;
			int b = num / 10 % 10;
			if (a - b != d)
				return 0;
			else
				num /= 10;
		}

		return 1;
	}
}
