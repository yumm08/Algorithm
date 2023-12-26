import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static long nums[];
	static long tree[];
	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new long[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		buildTree();
		
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				updateTree(1, 1, N, b, c);
			} else if (a == 2) {
				long sum = sumTree(1, 1, N, b, (int)c);
				System.out.println(sum);
			}
		}
	}

	private static long sumTree(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		return sumTree(node * 2, start, (start + end) / 2, left, right) +
				sumTree(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	private static void updateTree(int node, int start, int end, int index, long val) {
		if (start == end) {
			tree[node] = val;
			return;
		}
		
		if (start <= index && index <= (start + end) / 2) {
			updateTree(node * 2, start, (start + end) / 2, index, val);
		} else {
			updateTree(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
		}
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
		return;
	}

	private static void buildTree() {
		int height = (int) Math.ceil(Math.log(N) / Math.log(2));
		size = (int) Math.pow(2, height + 1);
		
		tree = new long[size];
		
		initTree(1, 1, N);
	}

	private static long initTree(int node, int start, int end) {

		if (start == end) {
			return tree[node] = nums[start];
		} else {
			return tree[node] = initTree(node * 2, start, (start + end)/2)
					+ initTree(node * 2 + 1, (start + end)/2 + 1, end);
		}
	}
}
