import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int area = 0;
        int paper[][] = new int[101][101];
        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (paper[i][j] == 0) {
                        paper[i][j] = 1;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
