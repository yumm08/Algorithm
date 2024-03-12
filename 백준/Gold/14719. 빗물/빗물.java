import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int total = H * W;
        int map[][] = new int[H][W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());
            total -= height;
            for (int j = 0; j < height; j++) {
                map[j][i] = 1;
            }
        }

        for (int i = 0; i < H; i++) {
            int check = 0;
            int temp = 0;
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 1) {
                    if (j < 1 || map[i][j-1] == 0) check++; 
                        
                    total += temp;
                    temp = 0;
                } else if (map[i][j] == 0) {
                    total--;
                    if (check >= 1) temp++;
                }
            } 
        }

        System.out.println(total);
    }
}
