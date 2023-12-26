import java.io.*;
import java.util.*;

public class Main {
    static int height[];
    static int diff[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        height = new int[N];
        diff = new int[N - 1];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            if (i > 0) diff[i - 1] = height[i] - height[i-1];
        }

        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < N - K; i++)
            ans += diff[i];

        System.out.println(ans);
    }
}