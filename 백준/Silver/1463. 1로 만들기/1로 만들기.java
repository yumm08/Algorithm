import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[1000001];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0 && i % 2 == 0) d[i] = Math.min(d[i-1], Math.min(d[i/3], d[i/2])) + 1;
            else if (i % 3 == 0) d[i] = Math.min(d[i-1], d[i/3]) + 1;
            else if (i % 2 == 0) d[i] = Math.min(d[i-1], d[i/2]) + 1;
            else d[i] = d[i-1] + 1;
        }
    
        if (N == 1) System.out.println("0");
        else System.out.println(d[N]);
    }
}