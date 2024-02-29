import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int num;
        int seatX, seatY;
        ArrayList<Integer> want = new ArrayList<>();

        public Node(int num, ArrayList<Integer> want) {
            this.num = num;
            this.want = want;
        }
    }

    static ArrayList<Node> list;
    static int[][] del = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] map;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        ArrayList<Integer> want;
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            want = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                want.add(Integer.parseInt(st.nextToken()));
            }
            list.add(new Node(num, want));
        }

        map = new int[N][N];
        for (Node now : list) {
            findSeat(now);
            // for (int i = 0; i < N; i++) {
            //     for (int j = 0; j < N; j++) {
            //         System.out.print(map[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        int totalCnt = checkTotalLikeCnt();
        System.out.println(totalCnt);
    }

    private static int checkTotalLikeCnt() {

        int totalLike = 0;
        for (Node now : list) {
            int like = 0;
            int x = now.seatX;
            int y = now.seatY;

            for (int l = 0; l < 4; l++) {
                int nx = x + del[l][0];
                int ny = y + del[l][1];

                if (in_range(nx, ny) && now.want.contains(map[nx][ny])) {
                    like++;
                }
            }

            if (like == 1) totalLike += 1;
            else if (like == 2) totalLike += 10;
            else if (like == 3) totalLike += 100;
            else if (like == 4) totalLike += 1000;
        }

        return totalLike;
    }

    private static void findSeat(Node now) {
        
        int[][] calcNum = new int[N][N];
        int likeCnt = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;

                if (now.want.contains(map[i][j])) {
                    for (int l = 0; l < 4; l++) {
                        int nx = i + del[l][0];
                        int ny = j + del[l][1];

                        if (in_range(nx, ny) && map[nx][ny] == 0) {
                            calcNum[nx][ny]++;
                            if (calcNum[nx][ny] > likeCnt) {
                                likeCnt = calcNum[nx][ny];
                            }
                        }
                    }
                }
            }
        }

        ArrayList<int[]> seatList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (calcNum[i][j] == likeCnt && map[i][j] == 0) {
                    seatList.add(new int[] {i, j});
                }
            }
        }

        int[] s = seatList.get(0);
        int emptyCnt = 0;
        for (int[] seat : seatList) {
            int i = seat[0];
            int j = seat[1];

            if (map[i][j] != 0) continue;

            for (int l = 0; l < 4; l++) {
                int nx = i + del[l][0];
                int ny = j + del[l][1];

                if (in_range(nx, ny) && map[nx][ny] == 0) {
                    calcNum[i][j]++;
                }
            }                    
            
            if (calcNum[i][j] > emptyCnt) {
                emptyCnt = calcNum[i][j];
                s[0] = i;
                s[1] = j;
            } 
        }

        map[s[0]][s[1]] = now.num;
        now.seatX = s[0];
        now.seatY = s[1];
    }

    private static boolean in_range(int nx, int ny) {
        return nx < N && nx >= 0 && ny < N && ny >= 0;
    }
}
