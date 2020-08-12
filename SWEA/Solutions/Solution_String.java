import java.io.*;

public class Solution_String {

	public static int[] getPi(String pattern) {
		int len = pattern.length();
		int[] pi = new int[len];

		for (int i = 1, j = 0; i < len; ++i) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i))
				j = pi[j - 1];

			if (pattern.charAt(j) == pattern.charAt(i))
				pi[i] = ++j;
		}

		return pi;
	}

	public static int KMP(String str, String pattern) {
		int count = 0;
		int slen = str.length(), plen = pattern.length();
		int[] pi = getPi(pattern);

		for (int i = 0, j = 0; i < slen; ++i) {
			while (j > 0 && str.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];

			if (str.charAt(i) == pattern.charAt(j)) {
				if (j == plen - 1) {
					++count;
					j = pi[j];
				} else
					++j;
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		while ((--T) >= 0) {
			int tnum = Integer.parseInt(br.readLine());
			String pattern = br.readLine();
			String str = br.readLine();

			bw.write("#" + tnum + " " + KMP(str, pattern) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
