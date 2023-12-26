import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int no;
        int totalDistance;

        public Vertex(int no, int totalDistance) {
            this.no = no;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.totalDistance - o.totalDistance;
        }
    }

    static int V, E;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        Node[] adjList = new Node[V + 1];
        int[] distance = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, weight, adjList[from]);
        }

        final int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);

        distance[start] = 0;

        boolean[] visit = new boolean[V + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(start, 0));

        Vertex current = null;

        while (!pq.isEmpty()) {
            current = pq.poll();
            if (visit[current.no])
                continue;

            visit[current.no] = true;
            for (Node temp = adjList[current.no]; temp != null; temp = temp.next) {
                if (!visit[temp.vertex] && distance[temp.vertex] > current.totalDistance + temp.weight) {
                    distance[temp.vertex] = current.totalDistance + temp.weight;
                    pq.offer(new Vertex(temp.vertex, distance[temp.vertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}