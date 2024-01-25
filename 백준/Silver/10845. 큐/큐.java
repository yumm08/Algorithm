import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Queue<Integer> queue = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		int last = -1;
		for (int times = 0; times < T; times++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				queue.add(last);
			} else if (str.equals("pop")) {
				if (!queue.isEmpty()) {
					sb.append(queue.poll() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (str.equals("size")) {
				sb.append(queue.size() + "\n");
			} else if (str.equals("empty")) {
				if (queue.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (str.equals("front")) {
				if (!queue.isEmpty()) {
					sb.append(queue.peek() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (str.equals("back")) {
				if (!queue.isEmpty()) {
					sb.append(last + "\n");
				} else {
					sb.append("-1\n");
				}
			}
		}

		System.out.println(sb);
	}
}
