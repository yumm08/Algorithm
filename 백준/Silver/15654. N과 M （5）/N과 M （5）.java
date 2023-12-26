import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] num, prt;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		prt = new int[M];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
		combination(0);
	}

	private static void combination(int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++)
				System.out.printf(prt[i] + " ");
			System.out.println("");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			prt[cnt] = num[i];
			visit[i] = true;
			combination(cnt + 1);
			visit[i] = false;
		}
	}
}