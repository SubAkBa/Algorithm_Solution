import java.util.*;
import java.io.*;

public class Solution_10610 {

	public static String Function30(char[] chr) {
		long total = 0;
		boolean zero = false;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chr.length; i++) {
			int num = chr[i] - '0';
			if (num == 0)
				zero = true;

			total += num;
		}

		if (!zero || total % 3 != 0)
			return "-1";

		Arrays.sort(chr);

		for (int i = chr.length - 1; i >= 0; i--)
			sb.append(chr[i]);

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] chr = br.readLine().toCharArray();

		bw.write(Function30(chr) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
