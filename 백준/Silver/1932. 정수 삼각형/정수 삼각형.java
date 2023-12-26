import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[(n * (n + 1)) / 2 + 1];
		int index = 1;
		for (int l = 0; l < n; l++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				arr[index++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int l = 2, i = 2; l <= n; l++) {
			for (int c = 0; c < l; c++, i++) {
				if (c == 0) {
					arr[i] += arr[i - l + 1];
				} else if (c == l - 1) {
					arr[i] += arr[i - l];
				} else if (arr[i - l + 1] > arr[i - l]) {
					arr[i] += arr[i - l + 1];
				} else if (arr[i - l + 1] <= arr[i - l]) {
					arr[i] += arr[i - l];
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < arr[(n * (n - 1)) / 2 + i]) 
				max = arr[(n * (n - 1)) / 2 + i];
		}
		System.out.println(max);
	}

}
