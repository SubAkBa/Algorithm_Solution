import java.util.*;
import java.io.*;

public class Solution_Kthsuffix {
	static Integer[] SA;
	static int[] g, tg;
	static int len, idx;

	public static void getSA(String str) {
		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				if (g[n1] == g[n2])
					return g[n1 + idx] - g[n2 + idx];

				return g[n1] - g[n2];
			}
		};

		for (int i = 0; i < len; i++) {
			SA[i] = i;
			g[i] = str.charAt(i) - 'a';
		}

		idx = 1;

		while (idx <= len) {
			g[len] = -1;

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

	public static boolean CompFunc(int n1, int n2, int idx) {
		if (g[n1] == g[n2])
			return g[n1 + idx] < g[n2 + idx];

		return g[n1] < g[n2];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			int K = Integer.parseInt(br.readLine());
			String str = br.readLine();

			len = str.length();
			SA = new Integer[len];
			g = new int[len + 1];
			tg = new int[len];

			getSA(str);

			bw.write("#" + (10 - T) + " \n");
			if (len <= K)
				bw.write("none\n");
			else
				bw.write(str.substring(SA[K - 1]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
