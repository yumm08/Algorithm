import java.io.*;

public class Main {
    static int quad[][];
    static StringBuilder prt = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        quad = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                quad[i][j] = str.charAt(j) - '0';
            }
        }

        compressQuadTree(0, 0, N);
        System.out.println(prt);
    }

    private static void compressQuadTree(int x, int y, int size) {

        if (size == 1 || checkAvailable(x, y, size)) {
            prt.append(quad[x][y]);
            return;
        }

        prt.append('(');
        compressQuadTree(x, y, size / 2);
        compressQuadTree(x, y + size / 2, size / 2);
        compressQuadTree(x + size / 2, y, size / 2);
        compressQuadTree(x + size / 2, y + size / 2, size / 2);
        prt.append(')');
    }

    private static boolean checkAvailable(int x, int y, int size) {
        
        int check = quad[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (quad[i][j] != check) return false;
            }
        }
        
        return true;
    }
}