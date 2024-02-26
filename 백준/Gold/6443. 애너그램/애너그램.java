import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static char[] str;
    static int len;
    static Set<String> strList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder prt = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int times = 0; times < N; times++) {
            str = br.readLine().toCharArray();
            int[] check = new int[26];
            for(char c : str) {
                check[c-'a']++;
            }
            len = str.length;
            strList = new TreeSet<>();
            findAll(new char[len], check, 0);

            Iterator iter = strList.iterator();
            while(iter.hasNext()) {
                prt.append(iter.next()).append("\n");
            }
        }

        System.out.println(prt);
    }

    private static void findAll(char[] arr, int[] check, int num) {
        if (num == len) {
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }

            strList.add(String.valueOf(sb));
        }
    
        for (int i = 0; i < 26; i++) {
            if (check[i] == 0) continue;
            check[i]--;
            arr[num] = (char)('a' + i);
            findAll(arr, check, num + 1);
            check[i]++;
        }
     
    }
}
