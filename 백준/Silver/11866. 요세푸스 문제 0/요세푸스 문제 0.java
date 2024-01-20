import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		StringBuilder prt = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		prt.append("<");
		while (!q.isEmpty()) {

			for (int i = 0; i < K - 1; i++) {
				int temp = q.remove();
				q.add(temp);
			}
			prt.append(q.remove());
			if (!q.isEmpty())
				prt.append(", ");
			else
				prt.append(">");
		}
		System.out.println(prt);
	}

}