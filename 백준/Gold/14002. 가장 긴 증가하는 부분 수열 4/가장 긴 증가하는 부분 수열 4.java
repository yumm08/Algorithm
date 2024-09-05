import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[];
	static int index;
	static int find[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		find = new int[N];
		find[0] = 1;
		int lis = 1;
		for (int i = 1; i < N; i++) {
			find[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					find[i] = Math.max(find[i], find[j] + 1);
					lis = Math.max(lis, find[i]);
				}
			}
		}

		sb.append(lis).append("\n");

		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (find[i] == lis) {
				stack.push(arr[i]);
				lis--;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}
}
