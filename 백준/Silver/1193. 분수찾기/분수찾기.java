import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());

		int cross = 1;
		int sum = 0;
		while (true) {
			if (X <= sum + cross) {
				if (cross % 2 == 1) {
					System.out.println((cross - (X - sum - 1)) + "/" + (X - sum));
					break;
				} else {
					System.out.println((X - sum) + "/" + (cross - (X - sum - 1)));
					break;
				}
			}

			sum += cross;
			cross++;
		}

	}
}
