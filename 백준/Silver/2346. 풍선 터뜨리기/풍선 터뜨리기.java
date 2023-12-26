import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder prt = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer str = new StringTokenizer(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(new int[] { i, Integer.parseInt(str.nextToken()) });
        }

        int[] del = q.poll();
        prt.append(del[0]).append(" ");
        while (!q.isEmpty()) {
            if (del[1] > 0) {
                for (int i = 0; i < del[1] - 1; i++) {
                    q.add(q.poll());
                }
                del = q.poll();
                prt.append(del[0]);
            } else if (del[1] < 0) {
                for (int i = 0; i < Math.abs(del[1]) - 1; i++) {
                    q.addFirst(q.pollLast());
                }
                del = q.pollLast();
                prt.append(del[0]);
            }
            if (!q.isEmpty())
                prt.append(" ");
        }

        System.out.println(prt);
    }
}