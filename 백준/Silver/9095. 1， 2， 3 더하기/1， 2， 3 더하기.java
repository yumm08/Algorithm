import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] num = new int[12];
		
		num[1] = 1;
		num[2] = 2;
		num[3] = 4;
		for (int i = 4; i <= 11; i++) {
			num[i] = num[i - 1] + num[i - 2] + num[i - 3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int times = 1; times <= T; times++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(num[N]).append("\n");
		}
		System.out.println(sb);
	} 
}
