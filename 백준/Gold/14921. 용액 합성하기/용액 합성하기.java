import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		while(true) {
			if(left==right) break;
			int sum = arr[left] + arr[right];
			if(Math.abs(sum) <= Math.abs(min)) {
				min = sum;
			}
			if(sum < 0) {
				left++;
			} else {
				right--;
			}
			
		}
		System.out.println(min);
	}
}