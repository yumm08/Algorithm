import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] taste;
    static int min_Diff;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        min_Diff = Math.abs(taste[0][0] - taste[0][1]);
        getMinTasteDiff(0, 1, 0);

        System.out.println(min_Diff);
    }

    private static void getMinTasteDiff(int cnt, int sour, int bitter) {
        if (cnt == N) {
            if (sour != 1 && bitter != 0)
                min_Diff = Math.min(min_Diff, Math.abs(bitter - sour));
        }
        else {
            getMinTasteDiff(cnt + 1, sour, bitter);

            sour *= taste[cnt][0];
            bitter += taste[cnt][1];
            getMinTasteDiff(cnt + 1, sour, bitter);
        }
    }
}
