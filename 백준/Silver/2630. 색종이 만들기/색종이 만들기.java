import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int N;
	static int count[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		countColors(0, 0, N);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}

	private static void countColors(int row, int col, int size) {
		if (checkColor(row, col, size)) {
			if (map[row][col] == 0) {
				count[0]++;
			} else
				count[1]++;

			return;
		}

		int newSize = size / 2;
		countColors(row, col, newSize);
		countColors(row, col + newSize, newSize);
		countColors(row + newSize, col, newSize);
		countColors(row + newSize, col + newSize, newSize);
	}

	private static boolean checkColor(int row, int col, int size) {

		int color = map[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
