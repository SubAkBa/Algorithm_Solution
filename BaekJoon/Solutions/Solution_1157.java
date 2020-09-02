import java.util.*;
import java.io.*;

public class string_1157_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		char[] ctr = br.readLine().toUpperCase().toCharArray();

		int[] count = new int[26];
		int max = 0, idx = 0;

		for (int i = 0; i < ctr.length; i++) {
			count[ctr[i] - 'A']++;

			max = Math.max(max, count[ctr[i] - 'A']);
		}

		for (int i = 0; i < 26; i++) {
			if (max == count[i]) {
				idx = i;
				sb.append(count[i] + " ");
			}
		}

		if (sb.toString().split(" ").length >= 2)
			bw.write("? ");
		else
			bw.write((char)(idx + 'A') + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
