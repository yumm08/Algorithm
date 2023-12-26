import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;
        while (B != A) {
            if (B < A){
                count = -1;
                break;
            } else if (B % 10 == 1) {
                B /= 10;
                count++;
            } else if (B % 2 == 0) {
                B /= 2;
                count++;
            } else {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }
}