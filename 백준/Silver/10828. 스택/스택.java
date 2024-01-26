import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		int last = -1;
		for (int times = 0; times < T; times++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				stack.add(last);
			} else if (str.equals("pop")) {
				if (!stack.isEmpty()) {
					sb.append(stack.pop() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (str.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (str.equals("empty")) {
				if (stack.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (str.equals("top")) {
				if (!stack.isEmpty()) {
					sb.append(stack.peek() + "\n");
				} else {
					sb.append("-1\n");
				}
			}
		}

		System.out.println(sb);
	}
}
