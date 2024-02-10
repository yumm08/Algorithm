import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int count[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str;

		int ans = 0;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			count = new int[27];
			if (checkGroup(str)) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static boolean checkGroup(String str) {

		for (int i = 0; i < str.length(); i++) {
			char check = str.charAt(i);

			for (int j = i; j < str.length(); j++) {
				if (check != str.charAt(j)) {
					i = j - 1;
					break;
				} else if (check == str.charAt(j)) {
					i++;
				}
			}

			if (count[check - 'a'] != 0) {
				return false;
			} else {
				count[check - 'a']++;
			}
		}

		return true;
	}
}
