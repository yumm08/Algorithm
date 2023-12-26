import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[];
	static int view[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		view = new int[N];
		for (int i = 0; i < N; i++) {
			double top = Integer.MIN_VALUE;

			for (int j = i + 1; j < N; j++) {
				int x = j - i;
				int y = map[j] - map[i];
				double in = (double) y / x;

				if (in > top) {
					view[i]++;
					view[j]++;
					top = in;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			// System.out.printf(view[i] + " ");
			if (view[i] > max) {
				max = view[i];
			}
		}
		// System.out.println();
		System.out.println(max);
	}
}
