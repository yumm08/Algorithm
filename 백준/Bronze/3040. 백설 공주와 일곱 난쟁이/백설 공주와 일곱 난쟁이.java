import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int seven[];
    static int findNum[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        seven = new int[9];
        for (int i = 0; i < 9; i++) {
            seven[i] = Integer.parseInt(br.readLine());
        }

        findNum = new int[7];
        combination(0, 0, 0);
    }

    private static void combination(int cnt, int start, int total) {
        if (cnt == 7 && total == 100) {
            printNumber(findNum);
            return;
        } else if (total > 100) return;
        else if (cnt == 7) return;

        for (int i = start; i < 9; i++) {
            findNum[cnt] = i;
            combination(cnt + 1, i + 1, total + seven[i]);
        }
    }

    private static void printNumber(int[] findNum) {
        for (int i : findNum) {
            System.out.println(seven[i]);
        }
    }
}