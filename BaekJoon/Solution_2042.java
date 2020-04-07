import java.util.*;
import java.io.*;

public class Solution_2042 {

	public static int AllocSize(int num) {
		return (int) Math.pow(2, (int) Math.ceil(Math.log(num) / Math.log(2)) + 1);
	}

	public static long InitPartialSum(long[] nums, long[] tree, int node, int start, int end) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;
		return tree[node] = InitPartialSum(nums, tree, node * 2, start, mid)
				+ InitPartialSum(nums, tree, node * 2 + 1, mid + 1, end);
	}

	public static void Update(long[] tree, int node, int idx, int start, int end, long diff) {
		if (!(start <= idx && idx <= end))
			return;

		tree[node] += diff;

		if (start != end) {
			int mid = (start + end) / 2;

			Update(tree, node * 2, idx, start, mid, diff);
			Update(tree, node * 2 + 1, idx, mid + 1, end, diff);
		}
	}

	public static long PartialSum(long[] tree, int node, int start, int end, int left, int right) {
		if (left > end || right < start)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return PartialSum(tree, node * 2, start, mid, left, right)
				+ PartialSum(tree, node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int size = AllocSize(N);
		long[] nums = new long[N];
		long[] tree = new long[size];

		for (int i = 0; i < N; i++)
			nums[i] = Long.parseLong(br.readLine());

		InitPartialSum(nums, tree, 1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int sep = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			switch (sep) {
			case 1:
				int idx = n1 - 1;
				long diff = n2 - nums[idx];
				nums[idx] = n2;
				Update(tree, 1, n1 - 1, 0, N - 1, diff);
				break;
			case 2:
				bw.write(PartialSum(tree, 1, 0, N - 1, n1 - 1, n2 - 1) + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}