import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static long[] arr;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        findLength(1, max + 1);
        System.out.println(ans);
    }

    private static void findLength(long start, long end) {
        
        long mid = (start + end) / 2;
        // System.out.println(mid);

        if (checkNum(mid)) {
            if (checkNum(mid + 1)) {
                findLength(mid + 1, end);
            } else {
                ans = mid;
            }
        } else {
            findLength(start, mid - 1);
        }
    }

    private static boolean checkNum(long mid) {

        int num = 0;

        for (int i = 0; i < K; i++) {
            long tmp = arr[i];
            while (tmp >= mid) {
                tmp -= mid;
                num++;
            }
        }

        return (num >= N);
    }
}