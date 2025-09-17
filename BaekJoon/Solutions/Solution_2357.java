import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2357 {
	static long[][] trees;
	static long[] nums;

	public static int getTreeSize(int N) {
		return Integer.highestOneBit(N) << 2;
	}

	public static void build(int start, int end, int node) {
		if (start == end) {
			trees[node][0] = trees[node][1] = nums[start];
			return;
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		build(start, mid, L);
		build(mid + 1, end, R);

		trees[node][0] = Math.min(trees[L][0], trees[R][0]);
		trees[node][1] = Math.max(trees[L][1], trees[R][1]);
	}

	public static long[] getMinMax(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return new long[] {Long.MAX_VALUE, Long.MIN_VALUE};
		}

		if (left <= start && end <= right) {
			return trees[node];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		long[] leftArray = getMinMax(start, mid, L, left, right);
		long[] rightArray = getMinMax(mid + 1, end, R, left, right);

		return new long[] {Math.min(leftArray[0], rightArray[0]), Math.max(leftArray[1], rightArray[1])};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int treeSize = getTreeSize(N);

		nums = new long[N + 1];
		trees = new long[treeSize + 1][2];

		for (int i = 1; i <= N; ++i) {
			nums[i] = Long.parseLong(br.readLine());
		}

		build(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			long[] minMax = getMinMax(1, N, 1, a, b);

			sb.append(minMax[0]).append(" ").append(minMax[1]).append("\n");
		}

		System.out.println(sb);
	}
}
