import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder prt = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        

        for (int times = 1; times <= T; times++) {

            StringTokenizer str = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(str.nextToken());
            int K = Integer.parseInt(str.nextToken());
            int count = 0;

            str = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                q.offer(new int[] {i, Integer.parseInt(str.nextToken())});
            }

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                boolean isMax = true;

                for (int i = 0; i < q.size(); i++) {
                    if (temp[1] < q.get(i)[1]) {
                        q.offer(temp);
                        isMax = false;
                        break;
                    }
                }

                if (isMax == true && temp[0] == K) {
                    prt.append(++count).append("\n");
                    break;
                }
                else if (isMax == true) {
                    count++;
                }
            }
        }
        System.out.println(prt);
    }
}