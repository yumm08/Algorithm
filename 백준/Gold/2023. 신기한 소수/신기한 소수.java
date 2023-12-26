import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] first = {2, 3, 5, 7};
    static int[] re = {1, 3, 7, 9};
    static int N;
    static int prime;
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        makePrime(0, 0);
    }
    
    private static void makePrime(int cnt, int prime) {
        
        if (cnt == N) {
            System.out.println(prime);
            return;
        }

        int[] arr;
        if (cnt == 0) arr = first;
        else arr = re;
        for (int i = 0; i < 4; i++) {
            int p = prime * 10 + arr[i];
            if (!checkPrime(p)) continue;
            
            makePrime(cnt + 1, p);
        }
        
    }

    private static boolean checkPrime(int prime) {

        for (int i = 3; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) return false;
        }

        return true;
    }
}