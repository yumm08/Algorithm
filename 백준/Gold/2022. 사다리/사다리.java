import java.io.*;
import java.util.*;

public class Main {
	static double x, y, c;
	static double h1, h2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());

		double dist = findDistance(c, x < y ? x : y);
		System.out.println(String.format("%.3f", dist));
	}

	private static double findDistance(double s, double e) {
		double dist;

		while (true) {
			dist = (s + e) / 2;
			double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(dist, 2));
			double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(dist, 2));

			double res = (h1 * h2) / (h1 + h2);

			if (res >= c)
				s = dist;
			else
				e = dist;

			if (e - s <= 0.001)
				break;
		}

		return dist;
	}
}