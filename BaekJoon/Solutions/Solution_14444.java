import java.io.*;

public class Solution_14444 {

	public static int Palindrome(String str) {
		int slen = str.length();
		char[] chr = new char[2 * slen + 1];
		chr[0] = '#';

		for (int i = 0; i < slen; i++) {
			chr[2 * i + 1] = str.charAt(i);
			chr[2 * i + 2] = '#';
		}

		int answer = 0, right = 0, cent = 0;
		int clen = chr.length;
		int[] rad = new int[clen];

		for (int i = 0; i < clen; i++) {
			if (i <= right)
				rad[i] = Math.min(right - i, rad[2 * cent - i]);

			while ((0 <= i - rad[i] - 1) && (i + rad[i] + 1 < clen) && chr[i - rad[i] - 1] == chr[i + rad[i] + 1])
				rad[i]++;

			if (right < i + rad[i]) {
				right = i + rad[i];
				cent = i;
			}

			answer = Math.max(answer, rad[i]);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		bw.write(Palindrome(str) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
