import java.util.*;
import java.io.*;

public class Solution_3653 {

	public static long Query(long[] tree, int idx) {
		long answer = 0;

		while (idx > 0) {
			answer += tree[idx];
			idx -= (idx & -idx);
		}

		return answer;
	}

	public static void Update(long[] tree, int idx, long diff) {
		while (idx < tree.length) {
			tree[idx] += diff;
			idx += (idx & -idx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int len = n + m + 1;
			int[] nums = new int[len];
			long[] tree = new long[len];

			for (int i = 1; i <= n; i++) {
				nums[i] = i + m;
				Update(tree, i + m, 1);
			}
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < m; i++) {
				int idx = Integer.parseInt(st.nextToken());
				bw.write((Query(tree, nums[idx]) - 1) + " ");

				Update(tree, nums[idx], -1);
				nums[idx] = m - i;
				Update(tree, nums[idx], 1);
			}

			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
