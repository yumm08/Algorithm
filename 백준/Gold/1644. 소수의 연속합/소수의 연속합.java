import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static boolean[] prime;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        prime = new boolean[N + 1];
        findPrime();
    
        int size = arr.size();
        int l = 0, r = 0;
        int sum = 0, count = 0;
        while (r < size) {
            if (sum > N) {
                sum -= arr.get(l++);
            } else if (sum < N) {
                sum += arr.get(r++);
            } else {
                count++;
                sum -= arr.get(l++);
            }
        }

        if(size > 0 && arr.get(--r) == N) count++;
        System.out.println(count);
    }

    private static void findPrime() {

        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= N; i++) {
            if (prime[i]) continue;

            arr.add(i);
            for (int j = i * 2; j <= N; j += i) {
                prime[j] = true;
            }
        }
    }
}
