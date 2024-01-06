import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double num[] = new double[N];
		double max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			max = Math.max(num[i], max);
		}

		double total = 0;
		for (int i = 0; i < N; i++) {
			num[i] = num[i] / max * 100;
			total += num[i];
		}

		System.out.println(total / N);
	}
}
