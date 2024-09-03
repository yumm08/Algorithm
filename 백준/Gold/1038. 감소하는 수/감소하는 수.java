import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static int index = 0;
	static long decNum[] = new long[1023];
	static int num[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	static boolean visit[] = new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		findDecreaseNum(0, 0);

		Arrays.sort(decNum, 0, 1023);

		if (N >= index)
			System.out.println("-1");
		else
			System.out.println(decNum[N]);
	}

	private static void findDecreaseNum(int start, long n) {
		if (start == 10)
			return;

		for (int i = start; i < 10; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			long temp = n * 10 + num[i];
			decNum[index++] = temp;
			findDecreaseNum(i + 1, temp);
			visit[i] = false;
		}
	}
}