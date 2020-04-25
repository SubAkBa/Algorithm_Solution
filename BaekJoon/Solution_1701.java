import java.util.*;
import java.io.*;

public class Solution_1701 {
	static int[] g, tg;
	static Integer[] SA;
	static int idx = 1, len;

	public static boolean CompFunc(int n1, int n2, int idx) {
		if (g[n1] == g[n2])
			return g[n1 + idx] < g[n2 + idx];

		return g[n1] < g[n2];
	}

	public static void GetSA(String str) {
		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (g[o1] == g[o2])
					return g[o1 + idx] - g[o2 + idx];

				return g[o1] - g[o2];
			}
		};

		for (int i = 0; i < len; i++) {
			SA[i] = i;
			g[i] = str.charAt(i) - 'a';
		}

		while (idx <= len) {
			g[len - 1] = -1;
			Arrays.sort(SA, comp);
			tg[SA[0]] = 0;

			for (int i = 1; i < len; i++) {
				if (CompFunc(SA[i - 1], SA[i], idx))
					tg[SA[i]] = tg[SA[i - 1]] + 1;
				else
					tg[SA[i]] = tg[SA[i - 1]];
			}

			for (int i = 0; i < len; i++)
				g[i] = tg[i];

			idx <<= 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		len = str.length();
		g = new int[len];
		tg = new int[len];
		SA = new Integer[len];
		int[] rank = new int[len];
//		int[] LCP = new int[len];
		int answer = 0;

		GetSA(str);

		for (int i = 0; i < len; i++)
			rank[SA[i]] = i;

		int lcplen = 0;

		for (int i = 0; i < len; i++) {
			int k = rank[i];

			if (k != 0) {
				int j = SA[k - 1];

				while ((j + lcplen) < len && (i + lcplen) < len && str.charAt(j + lcplen) == str.charAt(i + lcplen))
					lcplen++;

//				LCP[k] = lcplen;
				answer = Math.max(answer, lcplen);

				if (lcplen != 0)
					lcplen--;
			}
		}

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
