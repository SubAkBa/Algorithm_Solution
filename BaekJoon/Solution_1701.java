import java.io.*;

public class Solution_1701 {

	public static int GetPatternMaxlen(String pattern) {
		int len = pattern.length();
		int[] pi = new int[len];
		int maxlen = 0;

		for (int i = 1, j = 0; i < len; i++) {

			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];

			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
				maxlen = Math.max(maxlen, pi[i]);
			}
		}

		return maxlen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int max = 0;

		for (int i = 0; i < str.length(); i++)
			max = Math.max(GetPatternMaxlen(str.substring(i, str.length())), max);
		
		bw.write(max + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
