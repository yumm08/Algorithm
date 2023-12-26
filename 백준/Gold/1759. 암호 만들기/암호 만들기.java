import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char alphabet[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);

        visit = new boolean[C];
        makePassword(0, 0, new char[L]);
    }

    private static void makePassword(int cnt, int start, char[] arr) {
        if (cnt == L) {
            checkPossible(arr);
            return;
        }

        for (int i = start; i < C; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[cnt] = alphabet[i];
            makePassword(cnt + 1, i + 1, arr);
            visit[i] = false;
        }
    }

    private static void checkPossible(char[] arr) {
        StringBuilder sb = new StringBuilder();
        int vowels = 0;
        
        for (int i = 0; i < L; i++) {
            if (arr[i] == 'a' || arr[i] == 'i' || arr[i] == 'e' || arr[i] == 'o' || arr[i] == 'u') {
                vowels++;
            }
            sb.append(arr[i]);
        }

        if (vowels >= 1 && arr.length - vowels >= 2) {
            System.out.println(sb);
        }
    }
}