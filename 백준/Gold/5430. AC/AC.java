import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int times = 0; times < T; times++) {
			char[] arr = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			if (N > 0) {
				str = str.substring(1, str.length() - 1);
			}
			StringTokenizer st = new StringTokenizer(str);
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				deque.add(Integer.parseInt(st.nextToken(",")));
			}

			int r = 0;
			boolean error = false;
			for (char c : arr) {
				if (c == 'R') {
					r++;
				} else if (c == 'D') {
					if (deque.isEmpty()) {
						error = true;
						break;
					}

					if (r % 2 == 0) {
						deque.poll();
					} else if (r % 2 == 1) {
						deque.pollLast();
					}
				}
			}

			if (error) {
				sb.append("error\n");
			} else {
				sb.append("[");
				while (!deque.isEmpty()) {
					if (r % 2 == 0) {
						sb.append(deque.poll());
					} else if (r % 2 == 1) {
						sb.append(deque.pollLast());
					}
					if (!deque.isEmpty())
						sb.append(",");
				}

				sb.append("]\n");
			}
		}

		System.out.print(sb);
	}
}
