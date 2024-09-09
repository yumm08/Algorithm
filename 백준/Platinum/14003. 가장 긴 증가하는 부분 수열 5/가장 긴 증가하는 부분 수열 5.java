import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[];
	static int len;
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

		find = new int[N + 1];
		find[0] = Integer.MIN_VALUE;
		int[] dp = new int[N];
		len = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] <= find[len]) {
				int pos = searchPos(0, len, arr[i]);
				find[pos] = arr[i];
				dp[i] = pos;
			} else if (arr[i] > find[len]) {
				dp[i] = ++len;
				find[len] = arr[i];
			}
		}

		sb.append(len).append("\n");

		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == len) {
				stack.push(arr[i]);
				len--;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int searchPos(int start, int end, int elem) {
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;

			if (find[mid] < elem) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return end;
	}
}
