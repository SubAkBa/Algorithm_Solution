import java.io.*;
import java.util.*;

public class Solution_13275 {

	public static int Manacher(String str) {
		int len = str.length();
		int clen = len * 2 + 1;
		char[] ch = new char[clen];

		ch[0] = '#';
		for (int i = 0; i < len; i++) {
			ch[i * 2 + 1] = str.charAt(i);
			ch[i * 2 + 2] = '#';
		}

		int answer = 0, right = 0, cent = 0;
		int[] rad = new int[clen];

		for (int i = 0; i < clen; i++) {
			if (i <= right)
				rad[i] = Math.min(right - i, rad[2 * cent - i]);

			while ((0 <= i - rad[i] - 1 && i + rad[i] + 1 < clen) && ch[i + rad[i] + 1] == ch[i - rad[i] - 1])
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

		bw.write(Manacher(str) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
