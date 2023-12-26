import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> arr = new HashSet<>();
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String check = br.readLine();
			if (arr.contains(check)) {
				set.add(check);
			}
		}
		
		System.out.println(set.size());
		while (!set.isEmpty()) {
			System.out.println(set.pollFirst());
		}
	}

}