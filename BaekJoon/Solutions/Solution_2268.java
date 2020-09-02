import java.util.*;
import java.io.*;

public class Solution_2268 {
	static int N;

	public static void Update(long[] tree, int idx, long diff) {
		while (idx <= N) {
			tree[idx] += diff;
			idx += (idx & -idx);
		}
	}

	public static long Query(long[] tree, int idx) {
		long total = 0;

		while (idx > 0) {
			total += tree[idx];
			idx -= (idx & -idx);
		}

		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] tree = new long[N + 1];
		int[] nums = new int[N + 1];

		while ((M--) > 0) {
			st = new StringTokenizer(br.readLine());

			int C = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());

			switch (C) {
			case 0:
				int j = Integer.parseInt(st.nextToken());

				if (i > j) {
					int temp = i;
					i = j;
					j = temp;
				}

				bw.write((Query(tree, j) - Query(tree, i - 1)) + "\n");
				break;
			case 1:
				int k = Integer.parseInt(st.nextToken());
				long diff = k - nums[i];

				Update(tree, i, diff);

				nums[i] = k;
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}