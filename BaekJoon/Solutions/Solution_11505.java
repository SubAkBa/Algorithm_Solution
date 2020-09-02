import java.util.*;
import java.io.*;

public class Solution_11505 {
	static int MOD = 1000000007;

	public static int AllocSize(int n) {
		return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
	}

	public static long Init(int[] nums, long[] tree, int node, int start, int end) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;

		return tree[node] = (Init(nums, tree, node * 2, start, mid) % MOD * Init(nums, tree, node * 2 + 1, mid + 1, end)
				% MOD) % MOD;
	}

	public static long Query(long[] tree, int start, int end, int node, int left, int right) {
		if (end < left || start > right)
			return 1;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return Query(tree, start, mid, node * 2, left, right) * Query(tree, mid + 1, end, node * 2 + 1, left, right)
				% MOD;
	}

	public static long Update(long[] tree, int start, int end, int node, int idx, long diff) {
		if (!(start <= idx && idx <= end))
			return tree[node];

		if (start == end)
			return tree[node] = diff;

		int mid = (start + end) / 2;
		return tree[node] = Update(tree, start, mid, node * 2, idx, diff)
				* Update(tree, mid + 1, end, node * 2 + 1, idx, diff) % MOD;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int size = AllocSize(N);
		int[] nums = new int[N];
		long[] tree = new long[size];

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		Init(nums, tree, 1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			switch (a) {
			case 1:
				Update(tree, 0, N - 1, 1, b - 1, c);
				break;
			case 2:
				bw.write(Query(tree, 0, N - 1, 1, b - 1, c - 1) + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
