import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int front = 0;
        int back = arr.length - 1;
        long calc = Long.MAX_VALUE, tmp;
        long ans1 = 0, ans2 = 0;
        while (front != back) {
            tmp = arr[front] + arr[back];
            if (Math.abs(calc) > Math.abs(tmp)) {
                calc = tmp;
                ans1 = arr[front];
                ans2 = arr[back];
            }
            
            if (Math.abs(arr[front]) > Math.abs(arr[back])) {
                front++;
            } else {
                back--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
