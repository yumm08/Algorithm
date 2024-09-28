import java.io.*;
import java.util.*;

/**
 * PriorityQueue는 heap - BinaryTree 기반
 * TreeSet은 BinarySearchTree 기반
 * heap이 이진검색트리 기반의 자료구조들 보다 훨씬 메모리 사용량이 적음
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N - 1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}
