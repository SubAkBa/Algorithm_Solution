import java.io.*;

public class Solution_1543 {

	public static int Rabin_Carp(String str, String pattern) {
		int slen = str.length(), plen = pattern.length();
		int svalue = 0, pvalue = 0, count = 0;
		int power = 1, iter = 0;

		for (int i = 0; i <= slen - plen; i++) {
			if (i == 0) {
				for (int j = 0; j < plen; j++) {
					svalue += str.charAt(plen - 1 - j) * power;
					pvalue += pattern.charAt(plen - 1 - j) * power;
					power *= 2;
				}
				power /= 2;
			} else
				svalue = 2 * (svalue - str.charAt(i - 1) * power) + str.charAt(i + plen - 1);

			if ((--iter) > 0)
				continue;

			if (svalue == pvalue) {

				int j = 0;
				boolean finded = true;

				for (; j < plen; j++) {
					if (str.charAt(i + j) != pattern.charAt(j)) {
						finded = false;
						break;
					}
				}

				if (finded) {
					count++;
					iter = plen;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String pattern = br.readLine();

		bw.write(Rabin_Carp(str, pattern) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
