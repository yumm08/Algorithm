import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			if (!arr.contains(temp)) {
				arr.add(temp);
			}
		}

		arr.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
