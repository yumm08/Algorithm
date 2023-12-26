import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][]meeting;

        int N = Integer.parseInt(br.readLine());
        meeting = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] == o2[1]) {
                    if (o1[0] > o2[0]) return 11;
                    else return -1;
                } else return -1;
            }
        });
        
        int endTime = meeting[0][1];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (endTime <= meeting[i][0]) {
                endTime = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}