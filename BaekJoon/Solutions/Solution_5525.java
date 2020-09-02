import java.io.*;

public class Solution_5525 {

	public static int[] getPi(String pattern) {
		int len = pattern.length();
		int[] pi = new int[len];

		for (int i = 1, j = 0; i < len; i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i))
				j = pi[j - 1];

			if (pattern.charAt(j) == pattern.charAt(i))
				pi[i] = ++j;
		}

		return pi;
	}

	public static int KMP(String str, String pattern) {
		int len = str.length();
		int[] pi = getPi(pattern);
		int count = 0;

		for (int i = 0, j = 0; i < len; i++) {
			while (j > 0 && str.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];

			if (str.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					count++;
					j = pi[j];
				} else
					j++;
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String S = br.readLine();

		StringBuilder sb = new StringBuilder("I");
		for (int i = 0; i < N; i++)
			sb.append("OI");

		bw.write(KMP(S, sb.toString()) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
