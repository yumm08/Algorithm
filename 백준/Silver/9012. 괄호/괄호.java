import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		char[] str;
		Stack<Character> stack;

		for (int times = 0; times < T; times++) {
			str = br.readLine().toCharArray();
			stack = new Stack<>();

			boolean ans = true;
			for (int i = 0; i < str.length; i++) {
				if (str[i] == '(') {
					stack.add('(');
				} else if (stack.isEmpty()) {
					ans = false;
					break;
				} else if (str[i] == ')') {
					char chk = stack.pop();
					if (chk != '(') {
						ans = false;
						break;
					}
				}
			}

			if (!ans || !stack.isEmpty()) {
				sb.append("NO\n");
			} else {
				sb.append("YES\n");
			}
		}

		System.out.println(sb);
	}
}
