import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int five = 0;
		int two = 0;
		for (int i = 1; i <= N; i++) {

			int temp = i;
			while (temp % 5 == 0) {
				five++;
				temp /= 5;
			}

			temp = i;
			while (temp % 2 == 0) {
				two++;
				temp /= 2;
			}
		}

		System.out.println(Math.min(five, two));
	}
}
