import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int T = Integer.parseInt(br.readLine());

		for (int times = 0; times < T; times++) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0 && !stack.isEmpty()) {
				stack.poll();
			} else {
				stack.addFirst(N);
			}
		}

		int count = 0;
		while (!stack.isEmpty()) {
			count += stack.poll();
		}
		System.out.println(count);
	}
}