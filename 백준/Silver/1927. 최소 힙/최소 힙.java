import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0 && !pq.isEmpty()) {
				System.out.println(pq.poll());
			} else if (temp == 0 && pq.isEmpty()) {
				System.out.println("0");
			} else {
				pq.add(temp);
			}
		}
	}

}