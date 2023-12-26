import java.io.*;
import java.util.*;

public class Main {
	static int N, M, total = 0;
	static ArrayList<int[]> graph;
	static int map[][];
	static int maxArea = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					graph.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					total += 1;
				}
			}
		}

		// System.out.println(graph.get(0)[0] + " " + graph.get(0)[1]);
		findDirection(0, new int[graph.size()]);
		System.out.println(total - maxArea);
	}

	private static void findDirection(int i, int[] order) {
		if (i == graph.size()) {
			int[][] tempMap = copyMap(map);
			calcBlindArea(tempMap, order);
			return;
		}

		int x = graph.get(i)[0];
		int y = graph.get(i)[1];
		if (map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 4) {
			for (int d = 0; d < 4; d++) {
				order[i] = d;
				findDirection(i + 1, order);
			}
		} else if (map[x][y] == 2) {
			for (int d = 0; d < 2; d++) {
				order[i] = d;
				findDirection(i + 1, order);
			}
		} else if (map[x][y] == 5) {
			order[i] = 1;
			findDirection(i + 1, order);
		}
	}

	private static void calcBlindArea(int[][] temp, int[] order) {

		int totalArea = 0;

		for (int i = 0; i < graph.size(); i++) {
			int x = graph.get(i)[0];
			int y = graph.get(i)[1];

			if (map[x][y] == 1) {
				totalArea += typeOneCCTV(x, y, order[i], temp);
			} else if (map[x][y] == 2) {
				totalArea += typeTwoCCTV(x, y, order[i], temp);
			} else if (map[x][y] == 3) {
				totalArea += typeThreeCCTV(x, y, order[i], temp);
			} else if (map[x][y] == 4) {
				totalArea += typeFourCCTV(x, y, order[i], temp);
			} else if (map[x][y] == 5) {
				totalArea += typeFiveCCTV(x, y, order[i], temp);
			}
		}

		if (totalArea > maxArea)
			maxArea = totalArea;
	}

	private static int typeFiveCCTV(int x, int y, int o, int[][] temp) {
		int cnt = 0;
		int del[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int i = 0; i < 4; i++) {
			for (int j = 1;; j++) {
				int nx = x + del[i][0] * j;
				int ny = y + del[i][1] * j;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					break;

				if (temp[nx][ny] == 6) {
					break;
				} else if (temp[nx][ny] == 0) {
					cnt++;
					temp[nx][ny] = -1;
				}
			}
		}

		return cnt;
	}

	private static int typeFourCCTV(int x, int y, int o, int[][] temp) {
		int cnt = 0;
		int del[][] = {};

		if (o == 0) {
			del = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 } };
		} else if (o == 1) {
			del = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 } };
		} else if (o == 2) {
			del = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 } };
		} else if (o == 3) {
			del = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 } };
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 1;; j++) {
				int nx = x + del[i][0] * j;
				int ny = y + del[i][1] * j;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					break;

				if (temp[nx][ny] == 6) {
					break;
				} else if (temp[nx][ny] == 0) {
					cnt++;
					temp[nx][ny] = -1;
				}
			}
		}

		return cnt;
	}

	private static int typeThreeCCTV(int x, int y, int o, int[][] temp) {
		int cnt = 0;
		int del[][] = {};

		if (o == 0) {
			del = new int[][] { { 0, -1 }, { 1, 0 } };
		} else if (o == 1) {
			del = new int[][] { { 1, 0 }, { 0, 1 } };
		} else if (o == 2) {
			del = new int[][] { { 0, 1 }, { -1, 0 } };
		} else if (o == 3) {
			del = new int[][] { { -1, 0 }, { 0, -1 } };
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1;; j++) {
				int nx = x + del[i][0] * j;
				int ny = y + del[i][1] * j;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					break;

				if (temp[nx][ny] == 6) {
					break;
				} else if (temp[nx][ny] == 0) {
					cnt++;
					temp[nx][ny] = -1;
				}
			}
		}
		return cnt;
	}

	private static int typeTwoCCTV(int x, int y, int o, int[][] temp) {
		int cnt = 0;

		if (o == 0) {
			for (int i = x; i < N; i++) {
				if (temp[i][y] == 6) {
					break;
				} else if (temp[i][y] == 0) {
					cnt++;
					temp[i][y] = -1;
				}
			}

			for (int i = x; i >= 0; i--) {
				if (temp[i][y] == 6) {
					break;
				} else if (temp[i][y] == 0) {
					cnt++;
					temp[i][y] = -1;
				}
			}
		} else if (o == 1) {
			for (int i = y; i < M; i++) {
				if (temp[x][i] == 6) {
					break;
				} else if (temp[x][i] == 0) {
					cnt++;
					temp[x][i] = -1;
				}
			}

			for (int i = y; i >= 0; i--) {
				if (temp[x][i] == 6) {
					break;
				} else if (temp[x][i] == 0) {
					cnt++;
					temp[x][i] = -1;
				}
			}
		}

		return cnt;
	}

	private static int typeOneCCTV(int x, int y, int o, int[][] temp) {
		int cnt = 0;

		if (o == 0) {
			for (int i = x; i < N; i++) {
				if (temp[i][y] == 6) {
					break;
				} else if (temp[i][y] == 0) {
					cnt++;
					temp[i][y] = -1;
				}
			}
		} else if (o == 1) {
			for (int i = x; i >= 0; i--) {
				if (temp[i][y] == 6) {
					break;
				} else if (temp[i][y] == 0) {
					cnt++;
					temp[i][y] = -1;
				}
			}
		} else if (o == 2) {
			for (int i = y; i < M; i++) {
				if (temp[x][i] == 6) {
					break;
				} else if (temp[x][i] == 0) {
					cnt++;
					temp[x][i] = -1;
				}
			}
		} else if (o == 3) {
			for (int i = y; i >= 0; i--) {
				if (temp[x][i] == 6) {
					break;
				} else if (temp[x][i] == 0) {
					cnt++;
					temp[x][i] = -1;
				}
			}
		}

		return cnt;
	}

	private static int[][] copyMap(int[][] map) {
		int temp[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}

		return temp;
	}
}
