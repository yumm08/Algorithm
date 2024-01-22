import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0)
				break;

			boolean tri = false;

			if (a > b && a > c) {
				if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) {
					System.out.println("right");
					tri = true;
				}
			} else if (b > a && b > c) {
				if (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) {
					System.out.println("right");
					tri = true;
				}
			} else if (c > a && c > b) {
				if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
					System.out.println("right");
					tri = true;
				}
			}

			if (!tri)
				System.out.println("wrong");
		}
	}
}
