import java.util.*;
import java.io.*;

public class Solution_1010 {
	static long[][] counts;

	public static long Combination(int n, int r) {
		if (r == 0 || n == r)
			return counts[n][r] = 1;

		if (counts[n][r] != 0)
			return counts[n][r];

		return counts[n][r] = Combination(n - 1, r) + Combination(n - 1, r - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		counts = new long[31][31];

		while ((T--) > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			bw.write(Combination(M, N) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
