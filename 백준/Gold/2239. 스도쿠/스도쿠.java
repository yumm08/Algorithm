import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int map[][] = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        findAnswer(0, 0);
        System.out.println(sb);
    }

    private static boolean findAnswer(int x, int y) {

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            return true;
        }

        if (y == 9 && x < 9) {
            if (findAnswer(x + 1, 0))
                return true;
        } else if (map[x][y] != 0) {
            if (findAnswer(x, y + 1))
                return true;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!checkAvailability(x, y, i)) {
                    continue;
                }

                map[x][y] = i;
                if (findAnswer(x, y + 1))
                    return true;
                map[x][y] = 0;
            }
        }

        return false;
    }

    private static boolean checkAvailability(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == num)
                return false;
            if (map[x][i] == num)
                return false;
        }

        for (int i = 3 * (x / 3); i < 3 * (x / 3) + 3; i++) {
            for (int j = 3 * (y / 3); j < 3 * (y / 3) + 3; j++) {
                if (map[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}