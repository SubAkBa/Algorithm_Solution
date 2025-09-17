import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11505 {
	static long MOD = 1_000_000_007L;
	static long[] nums, trees;

	public static long build(int start, int end, int node) {
		if (start == end) {
			return trees[node] = nums[start];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return trees[node] = (build(start, mid, L) * build(mid + 1, end, R)) % MOD;
	}

	public static void update(int start, int end, int node, int idx, long val) {
		if (idx < start || end < idx) {
			return;
		}

		if (start == end) {
			trees[node] = val % MOD;
			return;
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		if (idx <= mid) {
			update(start, mid, L, idx, val);
		} else {
			update(mid + 1, end, R, idx, val);
		}

		trees[node] = (trees[L] * trees[R]) % MOD;
	}

	public static long query(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return 1;
		}

		if (left <= start && end <= right) {
			return trees[node];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return (query(start, mid, L, left, right) * query(mid + 1, end, R, left, right)) % 1000000007;
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

		for (int i = 1; i <= N; ++i) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		build(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				update(1, N, 1, b, c);
			} else if (a == 2) {
				sb.append(query(1, N, 1, b, c)).append("\n");
			}
		}

		System.out.println(sb);
	}
}
