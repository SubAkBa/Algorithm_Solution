import java.util.*;
import java.io.*;

public class Solution_2357 {
	public static int AllocSize(int n) {
		return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
	}

	public static long Init(long[] nums, long[] tree, int node, int start, int end, int p) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;

		if (p == 0)
			return tree[node] = Math.min(Init(nums, tree, node * 2, start, mid, 0),
					Init(nums, tree, node * 2 + 1, mid + 1, end, 0));
		else
			return tree[node] = Math.max(Init(nums, tree, node * 2, start, mid, 1),
					Init(nums, tree, node * 2 + 1, mid + 1, end, 1));
	}

	public static long Query(long[] tree, int node, int start, int end, int left, int right, int p) {
		if (right < start || left > end) {
			if (p == 0)
				return Long.MAX_VALUE;
			else
				return Long.MIN_VALUE;
		}

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		if (p == 0)
			return Math.min(Query(tree, node * 2, start, mid, left, right, 0),
					Query(tree, node * 2 + 1, mid + 1, end, left, right, 0));
		else
			return Math.max(Query(tree, node * 2, start, mid, left, right, 1),
					Query(tree, node * 2 + 1, mid + 1, end, left, right, 1));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int size = AllocSize(N);
		long[] nums = new long[N];
		long[] minTree = new long[size], maxTree = new long[size];

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		Init(nums, minTree, 1, 0, N - 1, 0);
		Init(nums, maxTree, 1, 0, N - 1, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(Query(minTree, 1, 0, N - 1, a - 1, b - 1, 0) + " " + Query(maxTree, 1, 0, N - 1, a - 1, b - 1, 1)
					+ "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
