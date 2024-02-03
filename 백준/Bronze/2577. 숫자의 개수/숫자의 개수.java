import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt[] = new int[10];
		int num = 1;
		for (int i = 0; i < 3; i++) {
			num *= Integer.parseInt(br.readLine());
		}

		while (num > 0) {
			cnt[num % 10]++;
			num /= 10;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}
	}
}
