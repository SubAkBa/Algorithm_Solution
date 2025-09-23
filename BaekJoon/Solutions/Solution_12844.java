import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_12844 {
	static int[] nums;
	static int[] trees;
	static int[] lazy;

	public static int build(int start, int end, int node) {
		if (start == end) {
			return trees[node] = nums[start];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return trees[node] = build(start, mid, L) ^ build(mid + 1, end, R);
	}

	public static void updateLazy(int start, int end, int node) {
		if (lazy[node] == 0) {
			return;
		}

		int len = end - start + 1;
		if ((len & 1) == 1) {
			trees[node] ^= lazy[node];
		}

		if (start != end) {
			int L = node << 1;
			int R = L | 1;

			lazy[L] ^= lazy[node];
			lazy[R] ^= lazy[node];
		}

		lazy[node] = 0;
	}

	public static void updateXorRange(int start, int end, int node, int left, int right, int val) {
		updateLazy(start, end, node);

		if (right < start || end < left) {
			return;
		}

		if (left <= start && end <= right) {
			lazy[node] ^= val;
			updateLazy(start, end, node);
			return;
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		updateXorRange(start, mid, L, left, right, val);
		updateXorRange(mid + 1, end, R, left, right, val);

		trees[node] = trees[L] ^ trees[R];
	}

	public static int query(int start, int end, int node, int left, int right) {
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

		return query(start, mid, L, left, right) ^ query(mid + 1, end, R, left, right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int treeSize = Integer.highestOneBit(N) << 2;
		nums = new int[N + 1];
		trees = new int[treeSize];
		lazy = new int[treeSize];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		build(1, N, 1);

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) + 1;
			int c = Integer.parseInt(st.nextToken()) + 1;

			if (a == 1) {
				int d = Integer.parseInt(st.nextToken());

				updateXorRange(1, N, 1, b, c, d);
			} else if (a == 2) {
				sb.append(query(1, N, 1, b, c)).append("\n");
			}
		}

		System.out.println(sb);
	}
}
