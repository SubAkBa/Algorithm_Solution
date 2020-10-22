import java.util.*;
import java.io.*;

public class Solution_13537 {

	public static int getSize(int N) {
		return (int) Math.pow(2, (int) Math.ceil(Math.log(N) / Math.log(2)) + 1);
	}

	public static List<Integer> Merge(List<Integer> left_subtree, List<Integer> right_subtree) {
		List<Integer> list = new ArrayList<>();
		int lidx = 0, ridx = 0;
		int llen = left_subtree.size(), rlen = right_subtree.size();

		while (lidx < llen && ridx < rlen) {
			int lvalue = left_subtree.get(lidx);
			int rvalue = right_subtree.get(ridx);

			if (lvalue <= rvalue) {
				list.add(lvalue);
				++lidx;
			} else {
				list.add(rvalue);
				++ridx;
			}
		}

		while (lidx < llen)
			list.add(left_subtree.get(lidx++));

		while (ridx < rlen)
			list.add(right_subtree.get(ridx++));

		return list;
	}

	public static List<Integer> Init(List<Integer>[] tree, int[] nums, int start, int end, int node) {
		if (start == end) {
			tree[node] = new ArrayList<>();
			tree[node].add(nums[start]);

			return tree[node];
		}

		int mid = (start + end) / 2;
		List<Integer> left_subtree = Init(tree, nums, start, mid, node * 2);
		List<Integer> right_subtree = Init(tree, nums, mid + 1, end, node * 2 + 1);

		return tree[node] = Merge(left_subtree, right_subtree);
	}

	public static int Query(List<Integer>[] tree, int start, int end, int left, int right, int node, int k) {
		if (right < start || left > end)
			return 0;

		if (left <= start && end <= right) {
			int tree_len = tree[node].size();

			return tree_len - Upper_Bound(tree[node], tree_len, k);
		}

		int mid = (start + end) / 2;

		return Query(tree, start, mid, left, right, node * 2, k)
				+ Query(tree, mid + 1, end, left, right, node * 2 + 1, k);
	}

	public static int Upper_Bound(List<Integer> list, int len, int k) {
		int left = 0, right = len - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (k < list.get(mid))
				right = mid;
			else
				left = mid + 1;
		}
	
		if(list.get(right) <= k)
			++right;

		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[N];
		for (int i = 0; i < N; ++i)
			nums[i] = Integer.parseInt(st.nextToken());

		int tree_size = getSize(N);
		List<Integer>[] tree = new ArrayList[tree_size];

		Init(tree, nums, 0, N - 1, 1);

		int M = Integer.parseInt(br.readLine());
		while ((--M) >= 0) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			bw.write(Query(tree, 0, N - 1, i - 1, j - 1, 1, k) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
