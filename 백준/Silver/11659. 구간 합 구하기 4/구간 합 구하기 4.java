import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder prt = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N && st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i != 0) arr[i] += arr[i-1];
        }

        for (int times = 0; times < M; times++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            prt.append(arr[end] - arr[start-1]).append("\n");
        }
        System.out.println(prt);
    }
}