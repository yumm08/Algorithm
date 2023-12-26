import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, total;
    static int population[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        population = new int[N + 1];
        total = 0;
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            total += population[i];
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int link = Integer.parseInt(st.nextToken());
            for (int j = 0; j < link; j++) {
                int node = Integer.parseInt(st.nextToken());
                graph.get(i).add(node);
            }
        }

        findMinimumDiff(1, 0, new boolean[N + 1]);
        if (min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min);
    }

    private static void findMinimumDiff(int start, int pop, boolean[] visit) {

        for (int i = start; i <= N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            boolean temp[] = new boolean[N + 1];
            boolean temp1[] = new boolean[N + 1];
            for (int j = 0; j <= N; j++) {
                temp[j] = visit[j];
                temp1[j] = !visit[j];
            }
            calcDiff(temp, temp1, pop + population[i]);
            findMinimumDiff(i + 1, pop + population[i], visit);
            visit[i] = false;
        }
    }

    private static void calcDiff(boolean[] visit, boolean[] check, int pop) {
        if(!checkConnected(visit)) return;
        if(!checkConnected(check)) return;
        
        int diff = Math.abs(total - pop * 2);
        min = Math.min(min, diff);
    }

    private static boolean checkConnected(boolean[] check) {
        int start = -1;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                start = i;
                break;
            }
        }

        if (start == -1)
            return false;

        queue.add(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            int find = queue.poll();

            for (int node : graph.get(find)) {
                if (check[node])
                    continue;
                queue.add(node);
                check[node] = true;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (!check[i])
                return false;
        }

        return true;
    }
}