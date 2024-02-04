import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char arr[] = br.readLine().toCharArray();
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder(new String(arr));
		System.out.println(sb.reverse().toString());
	}
}
