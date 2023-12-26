import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int color[][] = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int R[] = new int[N];
        int G[] = new int[N];
        int B[] = new int[N];
        R[0] = color[0][0];
        G[0] = color[0][1];
        B[0] = color[0][2];

        for (int i = 1; i < N; i++) {
            R[i] = Math.min(G[i-1], B[i-1]) + color[i][0];
            G[i] = Math.min(R[i-1], B[i-1]) + color[i][1];
            B[i] = Math.min(R[i-1], G[i-1]) + color[i][2];
        }

        System.out.println(Math.min(R[N-1], Math.min(G[N-1], B[N-1])));
    }
}