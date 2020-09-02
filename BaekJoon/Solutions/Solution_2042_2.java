import java.util.*;
import java.io.*;

public class Solution_2042_2 {

	public static long Sum(long[] tree, int idx) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];
		long[] tree = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			Update(tree, i, nums[i]);
		}

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			switch (a) {
			case 1:
				int idx = b;
				long diff = c - nums[idx];
				nums[idx] = c;
				Update(tree, idx, diff);
				break;
			case 2:
				bw.write(Sum(tree, c) - Sum(tree, b - 1) + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
