import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder prt = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> top = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int data = Integer.parseInt(st.nextToken());
            if (top.isEmpty()) {
                prt.append(0).append(" ");
                top.push(new int[] { i, data });
                continue;
            }

            if (top.peek()[1] >= data) {
                prt.append(top.peek()[0]).append(" ");
                top.push(new int[] { i, data });
            } else {
                while (!top.isEmpty() && top.peek()[1] < data)
                    top.pop();
                if (top.isEmpty()) {
                    prt.append(0).append(" ");
                    top.push(new int[] { i, data });
                    continue;
                }

                prt.append(top.peek()[0]).append(" ");
                top.push(new int[] { i, data });
            }
        }

        System.out.println(prt);
    }
}