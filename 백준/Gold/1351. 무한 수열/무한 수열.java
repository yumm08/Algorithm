import java.io.*;
import java.util.*;

public class Main {

	static Map<Long, Long> map;
	static long N;
	static int P, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		map = new HashMap<>();
		map.put(0L, 1L);
		
		System.out.println(find(N));
	}

	private static long find(long i) {
		
		if (i == 0) {
			return 1;
		}

		if (map.containsKey(i)) {
			return map.get(i);
		}

		map.put(i, find(i / P) + find(i / Q));
		return map.get(i);
	}
}
