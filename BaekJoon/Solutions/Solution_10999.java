import java.util.*;
import java.io.*;

public class Solution_10999 {

	public static int AllocSize(int n) {
		return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
	}

	public static long Init(int[] nums, long[] tree, int start, int end, int node) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;
		return tree[node] = Init(nums, tree, start, mid, node * 2) + Init(nums, tree, mid + 1, end, node * 2 + 1);
	}

	public static void Update_Range(long[] tree, long[] lazy, int start, int end, int left, int right, int node,
			long diff) {
		Update_Lazy(tree, lazy, start, end, node);

		if (right < start || left > end)
			return;

		if (left <= start && end <= right) {
			tree[node] += (end - start + 1) * diff;

			if (start != end) {
				lazy[node * 2] += diff;
				lazy[node * 2 + 1] += diff;
			}
			return;
		}

		int mid = (start + end) / 2;
		Update_Range(tree, lazy, start, mid, left, right, node * 2, diff);
		Update_Range(tree, lazy, mid + 1, end, left, right, node * 2 + 1, diff);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void Update_Lazy(long[] tree, long[] lazy, int start, int end, int node) {
		if (lazy[node] != 0) {
			tree[node] += (end - start + 1) * lazy[node];
			if (start != end) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}

			lazy[node] = 0;
		}
	}

	public static long Query(long[] tree, long[] lazy, int start, int end, int left, int right, int node) {
		Update_Lazy(tree, lazy, start, end, node);

		if (right < start || left > end)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return Query(tree, lazy, start, mid, left, right, node * 2) + Query(tree, lazy, mid + 1, end, left, right, node * 2 + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		int size = AllocSize(N);
		long[] tree = new long[size];
		long[] lazy = new long[size];

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		Init(nums, tree, 0, N - 1, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			switch (a) {
			case 1:
				int d = Integer.parseInt(st.nextToken());
				Update_Range(tree, lazy, 0, N - 1, b - 1, c - 1, 1, d);
				break;
			case 2:
				bw.write(Query(tree, lazy, 0, N - 1, b - 1, c - 1, 1) + "\n");
				break;
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
