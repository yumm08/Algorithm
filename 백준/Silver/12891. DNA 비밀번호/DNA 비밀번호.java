import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int S, P;
    static String[] dna;
    static int min_num[];
    static int chk_num[];
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        String temp = br.readLine();
        dna = temp.split("");

        min_num = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min_num[i] = Integer.parseInt(st.nextToken());
        }

        chk_num = new int[4];
        for (int i = 0; i < P; i++) {
            chk_num[dnaCheck(dna[i])]++;
        }

        count = checkAvailability(chk_num);
        for (int i = 1; i <= S - P; i++) {
            
            chk_num[dnaCheck(dna[i - 1])]--;
            chk_num[dnaCheck(dna[i + P - 1])]++;
            count += checkAvailability(chk_num);
        }
        System.out.println(count);
    }

    private static int dnaCheck(String dna) {

        if (dna.equals("A")) return 0;
        else if (dna.equals("C")) return 1;
        else if (dna.equals("G")) return 2;
        else if (dna.equals("T")) return 3;
        return -1;
    }

    private static int checkAvailability(int[] chk_num) {

        int chk = 1;

        for (int i = 0; i < 4; i++) {
            if (chk_num[i] < min_num[i])
                chk = 0;
        }
        return chk;
    }
}