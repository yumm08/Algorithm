import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] preorder, inorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int times = 0; times < T; times++) {
            n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }
            
            inorder = new int[n];            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
            }

            findTreeByPostOrder(0, 0, n);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void findTreeByPostOrder(int root, int start, int end) {

        for (int i = start; i < end; i++) {
            if (preorder[root] == inorder[i]) {
                findTreeByPostOrder(root + 1, start, i);
                findTreeByPostOrder(root + i - start + 1, i + 1, end);
                sb.append(preorder[root]).append(" ");
            }
        }

    }
}
