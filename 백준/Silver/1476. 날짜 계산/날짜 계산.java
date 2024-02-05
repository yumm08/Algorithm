import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 0, s = 0, m = 0;
		int answer = 0;

		while (true) {
			e++;
			s++;
			m++;
			answer++;

			if (e > 15)
				e = 1;
			if (s > 28)
				s = 1;
			if (m > 19)
				m = 1;

			if (e == E && s == S && m == M)
				break;
		}

		System.out.println(answer);
	}
}
