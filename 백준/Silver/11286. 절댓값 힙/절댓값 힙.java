import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> pq = new PriorityQueue<>(new ComparatorAbs());
        StringBuilder prt = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int times = 0; times < T; times++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) prt.append(0).append("\n");
                else prt.append(pq.poll()).append("\n");
            } else pq.add(num);
        }
        System.out.println(prt);
    }
}

class ComparatorAbs implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (Math.abs(o1) > Math.abs(o2))
            return 1;
        else if (Math.abs(o1) < Math.abs(o2))
            return -1;
        else if (Math.abs(o1) == Math.abs(o2)) {
            if (o1 < o2)
                return -1;
            return 1;
        }
        return 0;
    }
}