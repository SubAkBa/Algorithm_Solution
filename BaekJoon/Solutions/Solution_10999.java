import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10999 {
	static long[] nums;
	static long[] trees;
	static long[] lazy;

	public static long build(int start, int end, int node) {
		if (start == end) {
			return trees[node] = nums[start];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return trees[node] = build(start, mid, L) + build(mid + 1, end, R);
	}

	public static long query(int start, int end, int node, int left, int right) {
		updateLazy(start, end, node);

		if (right < start || end < left) {
			return 0;
		}

		if (left <= start && end <= right) {
			return trees[node];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return query(start, mid, L, left, right) + query(mid + 1, end, R, left, right);
	}

	public static void updateLazy(int start, int end, int node) {
		if (lazy[node] == 0) {
			return;
		}

		trees[node] += lazy[node] * (end - start + 1);

		if (start != end) {
			int L = node << 1;
			int R = L | 1;

			lazy[L] += lazy[node];
			lazy[R] += lazy[node];
		}

		lazy[node] = 0;
	}

	public static void updateRange(int start, int end, int node, int left, int right, long val) {
		updateLazy(start, end, node);

		if (right < start || end < left) {
			return;
		}

		if (left <= start && end <= right) {
			lazy[node] += val;
			updateLazy(start, end, node);
			return;
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		updateRange(start, mid, L, left, right, val);
		updateRange(mid + 1, end, R, left, right, val);

		trees[node] = trees[L] + trees[R];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int treeSize = Integer.highestOneBit(N) << 2;

		nums = new long[N + 1];
		trees = new long[treeSize];
		lazy = new long[treeSize];

		for (int i = 1; i <= N; ++i) {
			nums[i] = Long.parseLong(br.readLine());
		}

		build(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				long d = Long.parseLong(st.nextToken());

				updateRange(1, N, 1, b, c, d);
			} else if (a == 2) {
				sb.append(query(1, N, 1, b, c)).append("\n");
			}
		}

		System.out.println(sb);
	}
}
