import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int T = Integer.parseInt(br.readLine());
		for (int times = 0; times < T; times++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push_back")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if (str.equals("push_front")) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if (str.equals("pop_front")) {
				if (!deque.isEmpty()) {
					sb.append(deque.pollFirst() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (str.equals("pop_back")) {
				if (!deque.isEmpty()) {
					sb.append(deque.pollLast() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (str.equals("size")) {
				sb.append(deque.size() + "\n");
			} else if (str.equals("empty")) {
				if (deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (str.equals("front")) {
				if (!deque.isEmpty()) {
					sb.append(deque.peekFirst() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (str.equals("back")) {
				if (!deque.isEmpty()) {
					sb.append(deque.peekLast() + "\n");
				} else {
					sb.append("-1\n");
				}
			}
		}

		System.out.println(sb);
	}
}
