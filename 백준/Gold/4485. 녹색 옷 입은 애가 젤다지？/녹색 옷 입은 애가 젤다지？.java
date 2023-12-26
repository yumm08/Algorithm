import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int to[];
		int cost;

		Node(int to[], int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int N;
	static int map[][];
	static int minRupee;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			sb.append("Problem ").append(++cnt).append(": ");
			
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			earnRupee();
			sb.append(minRupee).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void earnRupee() {
		int rupee[][] = new int[N][N];
		int del[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rupee[i][j] = Integer.MAX_VALUE;
			}
		}
		rupee[0][0] = map[0][0];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(new int[] {0, 0}, map[0][0]));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.to[0] == N - 1 && cur.to[1] == N - 1) {
				minRupee = cur.cost;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.to[0] + del[i][0];
				int ny = cur.to[1] + del[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (rupee[nx][ny] > cur.cost + map[nx][ny]) {
					rupee[nx][ny] = cur.cost + map[nx][ny];
					pq.offer(new Node(new int[] {nx, ny}, rupee[nx][ny]));
				}
			}
		}
	}
}