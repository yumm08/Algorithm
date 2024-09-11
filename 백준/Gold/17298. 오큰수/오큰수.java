import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 중요한 점은 arr의 index 값을 저장해서 오큰수를 찾는 것
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 스택에 0을 push
		for (int i = 1; i < N; i++) {
			// 스택이 비어있지 않고 스택의 peek의 index가 현재값보다 작은 경우
			// 오큰수이므로 arr[stack.pop()] = arr[i]
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i); // 스택이 비어있거나 arr[stack.peek()] 값이 현재값보다 큰 경우 push
		}

		// 끝까지 arr를 다 돌았을때 아직 stack에 남아있는 값들은
		// 오큰수가 없는 값이므로 stack 내부에 남아있는 값을 전부 -1로 변경
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb);
	}
}
