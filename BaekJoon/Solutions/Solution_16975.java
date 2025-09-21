import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_16975 {
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

	public static void updateLazy(int start, int end, int node) {
		if (lazy[node] == 0) {
			return;
		}

		trees[node] += (end - start + 1) * lazy[node];

		if (start != end) {
			int L = node << 1;
			int R = L | 1;

			lazy[L] += lazy[node];
			lazy[R] += lazy[node];
		}

		lazy[node] = 0;
	}

	public static void addRange(int start, int end, int node, int left, int right, long val) {
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

		addRange(start, mid, L, left, right, val);
		addRange(mid + 1, end, R, left, right, val);

		trees[node] = trees[L] + trees[R];
	}

	public static long pointQuery(int start, int end, int node, int idx) {
		updateLazy(start, end, node);

		if (start == end) {
			return trees[node];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;


		if (idx <= mid) {
			return pointQuery(start, mid, L, idx);
		} else {
			return pointQuery(mid + 1, end, R, idx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		nums = new long[N + 1];
		trees = new long[Integer.highestOneBit(N) << 2];
		lazy = new long[Integer.highestOneBit(N) << 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		build(1, N, 1);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());

				addRange(1, N, 1, b, c, d);
			} else if (a == 2) {
				sb.append(pointQuery(1, N, 1, b)).append("\n");
			}
		}

		System.out.println(sb);
	}
}
