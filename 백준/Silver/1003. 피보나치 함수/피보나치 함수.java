import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int times = 1; times <= T; times++) {
			int N = Integer.parseInt(br.readLine());
			int[] zero = new int[N+1];
			int[] one = new int[N+1];
			
			zero[0] = 1;
			one[0] = 0;
			if (N > 0) {
				zero[1] = 0;
				one[1] = 1;
			}
			for (int i = 2; i <= N; i++) {
				zero[i] = zero[i-1] + zero[i-2];
				one[i] = one[i-1] + one[i-2];
			}
			
			sb.append(zero[N]).append(" ").append(one[N]).append("\n");
		}
		
		System.out.println(sb);
	}

}
