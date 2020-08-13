import java.util.*;

public class Solution_CountofSmallerNumbersAfterSelf {
	static int tree_len;

	public static void Update(int[] tree, int idx) {
		while (idx < tree_len) {
			tree[idx]++;
			idx += (idx & -idx);
		}
	}

	public static int Query(int[] tree, int idx) {
		int sum = 0;

		while (idx > 0) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}

		return sum;
	}

	public static List<Integer> countSmaller(int[] nums) {
		int len = nums.length;

		if (len == 0)
			return new ArrayList<>();

		HashMap<Integer, Integer> num2idx = new HashMap<>();
		int[] sorted = Arrays.copyOf(nums, len);
		Arrays.sort(sorted);
		tree_len = 1;

		for (int i = 0; i < len; i++) {
			if (!num2idx.containsKey(sorted[i]))
				num2idx.put(sorted[i], tree_len++);
		}

		int[] tree = new int[tree_len];
		List<Integer> result = new LinkedList<>();

		for (int i = len - 1; i >= 0; i--) {
			result.add(0, Query(tree, num2idx.get(nums[i]) - 1));
			Update(tree, num2idx.get(nums[i]));
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));
		System.out.println(countSmaller(new int[] { 5, 5, 5, 5 }));
	}

}
