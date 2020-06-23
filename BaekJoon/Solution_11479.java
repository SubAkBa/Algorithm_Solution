import java.util.*;
import java.io.*;

public class Solution_11479 {
	static Integer[] SA;
	static int[] g, tg, LCP;
	static int len, idx;

	public static class SASort implements Comparator<Integer> {
		public int compare(Integer n1, Integer n2) {
			if (g[n1] == g[n2])
				return g[n1 + idx] - g[n2 + idx];

			return g[n1] - g[n2];
		}
	}

	public static void GetSA(String str) {
		SASort sort = new SASort();

		for (int i = 0; i < len; i++) {
			SA[i] = i;
			g[i] = str.charAt(i) - 'a';
		}

		idx = 1;

		while (idx <= len) {
			g[len] = -1;
			Arrays.sort(SA, sort);
			tg[SA[0]] = 0;

			for (int i = 1; i < len; i++) {
				if (sort.compare(SA[i - 1], SA[i]) < 0)
					tg[SA[i]] = tg[SA[i - 1]] + 1;
				else
					tg[SA[i]] = tg[SA[i - 1]];
			}

			for (int i = 0; i < len; i++)
				g[i] = tg[i];

			idx <<= 1;
		}
	}

	public static void GetLCP(String str) {
		int[] rank = new int[len];
		int lcplen = 0;

		for (int i = 0; i < len; i++)
			rank[SA[i]] = i;

		for (int i = 0; i < len; i++) {
			int k = rank[i];

			if (k != 0) {
				int j = SA[k - 1];

				while ((i + lcplen < len) && (j + lcplen < len) && str.charAt(i + lcplen) == str.charAt(j + lcplen))
					lcplen++;

				LCP[k] = lcplen;

				if (lcplen != 0)
					lcplen--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		len = str.length();
		SA = new Integer[len];
		g = new int[len + 1];
		tg = new int[len];
		LCP = new int[len];

		GetSA(str);
		GetLCP(str);

		long answer = 0;

		for (int i = 0; i < len; i++)
			answer += len - SA[i] - LCP[i];

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
