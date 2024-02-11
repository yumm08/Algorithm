import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[];
	static int index;
	static int find[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		find = new int[N];

		index = 0;
		find[0] = arr[0];
		for (int i = 0; i < N; i++) {
			find[i] = arr[i];

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					find[i] = Math.max(find[j] + arr[i], find[i]);
			}

		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(find[i], max);
		}

		System.out.println(max);
	}
}
