import java.util.*;
import java.io.*;

public class kmp_1786_solution {

	public static int[] getPi(String pattern) {
		int len = pattern.length();
		int[] pi = new int[len];

		for (int i = 1, j = 0; i < len; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];

			if (pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}

		return pi;
	}

	public static List<Integer> KMP(String text, String pattern) {
		List<Integer> idxlist = new ArrayList<>();
		int len = text.length();
		int[] pi = getPi(pattern);

		for (int i = 0, j = 0; i < len; i++) {
			while (j > 0 && text.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];

			if (text.charAt(i) == pattern.charAt(j)) {
				
				if (j == pattern.length() - 1) {
					idxlist.add(i - pattern.length() + 2);
					j = pi[j];
				} else
					j++;
			}
		}

		return idxlist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String text = br.readLine();
		String pattern = br.readLine();

		List<Integer> answer = KMP(text, pattern);

		bw.write(answer.size() + "\n");
		for (int idx : answer)
			bw.write(idx + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
