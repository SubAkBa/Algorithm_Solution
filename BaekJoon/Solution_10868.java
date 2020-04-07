import java.util.*;
import java.io.*;

public class Solution_10868 {
	public static int AllocSize(int n) {
		return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
	}

	public static long minInit(long[] nums, long[] tree, int node, int start, int end) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;

		return tree[node] = Math.min(minInit(nums, tree, node * 2, start, mid),
				minInit(nums, tree, node * 2 + 1, mid + 1, end));
	}

	public static long minQuery(long[] tree, int node, int start, int end, int left, int right) {
		if (right < start || left > end)
			return Long.MAX_VALUE;
		
		if(left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return Math.min(minQuery(tree, node * 2, start, mid, left, right),
				minQuery(tree, node * 2 + 1, mid + 1, end, left, right));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int size = AllocSize(N);
		long[] nums = new long[N];
		long[] mintree = new long[size];

		for (int i = 0; i < N; i++)
			nums[i] = Long.parseLong(br.readLine());

		minInit(nums, mintree, 1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(minQuery(mintree, 1, 0, N - 1, a - 1, b - 1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
