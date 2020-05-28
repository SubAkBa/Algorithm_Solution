import java.util.*;
import java.io.*;

public class Solution_3033 {

	static int[] g;
	static int idx;

	public static class Comp implements Comparator<Integer> {
		public int compare(Integer n1, Integer n2) {
			if (g[n1] == g[n2])
				return g[n1 + idx] - g[n2 + idx];

			return g[n1] - g[n2];
		}
	}

	public static Integer[] getSA(String str, int N) {
		Comp comp = new Comp();
		Integer[] SA = new Integer[N];
		int[] tg = new int[N];

		for (int i = 0; i < N; i++) {
			SA[i] = i;
			g[i] = str.charAt(i) - 'a';
		}

		idx = 1;

		while (idx <= N) {
			g[N] = -1;
			Arrays.sort(SA, comp);
			tg[SA[0]] = 0;

			for (int i = 1; i < N; i++) {
				if (comp.compare(SA[i - 1], SA[i]) < 0)
					tg[SA[i]] = tg[SA[i - 1]] + 1;
				else
					tg[SA[i]] = tg[SA[i - 1]];
			}

			for (int i = 0; i < N; i++)
				g[i] = tg[i];

			idx <<= 1;
		}

		return SA;
	}

	public static int MaxLCP(String str, Integer[] SA, int N) {
		int answer = 0, lcplen = 0;
		int[] rank = new int[N];

		for (int i = 0; i < N; i++)
			rank[SA[i]] = i;

		for (int i = 0; i < N; i++) {
			int k = rank[i];

			if (k > 0) {
				int j = SA[k - 1];

				while ((i + lcplen < N) && (j + lcplen < N) && str.charAt(i + lcplen) == str.charAt(j + lcplen))
					lcplen++;

				answer = Math.max(answer, lcplen);

				if (lcplen > 0)
					lcplen--;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();
		g = new int[N + 1];

		bw.write(MaxLCP(str, getSA(str, N), N) + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
