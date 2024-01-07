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
		for (int i = 1; i < N; i++) {
			if (arr[i] < find[index]) {
				int pos = searchPos(0, index, i);
				find[pos] = arr[i];
			} else if (arr[i] > find[index]) {
				find[++index] = arr[i];
			}
		}

		System.out.println(index + 1);
	}

	private static int searchPos(int start, int end, int elem) {

		if (start == end)
			return start;

		int mid = (start + end) / 2;

		if (find[mid] > arr[elem]) {
			if (mid == index)
				return mid;
			return searchPos(start, mid, elem);
		} else if (find[mid] < arr[elem]) {
			if (find[mid + 1] > arr[elem]) {
				return mid + 1;
			}
			return searchPos(mid, end, elem);
		}

		return mid;
	}
}
