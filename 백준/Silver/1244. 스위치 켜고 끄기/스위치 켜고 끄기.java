import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[][] std;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int std_num = sc.nextInt();
        std = new int[std_num][2];
        for (int i = 0; i < std_num; i++) {
            std[i][0] = sc.nextInt();
            std[i][1] = sc.nextInt();
        }

        for (int i = 0; i < std_num; i++) {
            switch_on_off(i);
        }

        for (int i = 1; i < arr.length; i++) {
            str.append(arr[i]);
            if (i % 20 == 0)
                str.append("\n");
            else
                str.append(" "); 
        }
        System.out.println(str);
        sc.close();
    }

    private static void switch_on_off(int n) {

        if (std[n][0] == 1)
            man(std[n][1]);
        else if (std[n][0] == 2)
            women(std[n][1]);
    }

    private static void women(int n) {

        for (int i = 0; n + i < arr.length && n - i > 0; i++) {
            int back = n + i;
            int front = n - i;

            if (arr[back] == arr[front]) {
                if (arr[back] == 0) {
                    arr[back] = 1;
                    arr[front] = 1;
                } else if (arr[back] == 1){
                    arr[back] = 0;
                    arr[front] = 0;
                }
            } else break;
        }
    }

    private static void man(int n) {

        for (int i = 1; i * n < arr.length; i++) {
            if (arr[n * i] == 0)
                arr[n * i] = 1;
            else
                arr[n * i] = 0;
        }

    }
}