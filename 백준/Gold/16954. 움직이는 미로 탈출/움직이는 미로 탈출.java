import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Node {
        int x;
        int y;
        int ver;

        public Node(int x, int y, int ver) {
            this.x = x;
            this.y = y;
            this.ver = ver;
        }
    }
    static char[][] map;
    static int[][] del = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        escapeMap();

    }

    private static void escapeMap() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(7, 0, 0));
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == 0 && now.y == 7) {
                System.out.println(1);
                return;
            }

            for (int l = 0; l < 9; l++) {
                int nx = now.x + del[l][0];
                int ny = now.y + del[l][1];

                if (!in_range(nx, ny) || !isPossible(nx, ny, now.ver)) {
                    continue;
                }

                queue.add(new Node(nx, ny, now.ver + 1));
            }
        }

        System.out.println(0);
    }

    private static boolean isPossible(int x, int y, int ver) {
        if (x >= 1 + ver) {
            return map[x - 1 - ver][y] == '.' && map[x - ver][y] == '.'; 
        } else if (x >= ver) {
            return map[x - ver][y] == '.'; 
        }
        else return true;
    }

    private static boolean in_range(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }
}
