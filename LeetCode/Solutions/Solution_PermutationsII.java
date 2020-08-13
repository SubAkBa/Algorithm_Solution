import java.util.*;

public class Solution_PermutationsII {

	public static void Permutation(List<List<Integer>> answer, List<Integer> list, int[] nums, int idx, int len,
			boolean[] selected) {
		if (idx == len) {
			answer.add(new ArrayList<>(list));
			return;
		}

		Set<Integer> cache = new HashSet<>();

		for (int i = 0; i < len; ++i) {
			if (selected[i] || cache.contains(nums[i]))
				continue;

			cache.add(nums[i]);
			selected[i] = true;
			list.add(nums[i]);

			Permutation(answer, list, nums, idx + 1, len, selected);

			selected[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		int len = nums.length;

		Permutation(answer, new ArrayList<>(), nums, 0, len, new boolean[len]);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}

}
