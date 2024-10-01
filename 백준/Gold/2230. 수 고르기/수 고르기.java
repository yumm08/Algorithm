import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int answer = Integer.MAX_VALUE;
		
		int s = 0;
		int e = 0;
		while(e < N && s <= e) {
			int rst = arr[e] - arr[s];
			if(rst >= M) {
				s++;
				answer = Math.min(answer, rst);
			}
			else {
				e++;
			}
		}
		
		System.out.println(answer);
	}

}