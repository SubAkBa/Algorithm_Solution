import java.util.*;

public class Solution_Permutations {

	public static void Permutation(int[] nums, List<List<Integer>> answer, List<Integer> list, int idx, int len,
			boolean[] selected) {
		if (idx == len) {
			answer.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < len; ++i) {
			if (selected[i])
				continue;

			selected[i] = true;
			list.add(nums[i]);

			Permutation(nums, answer, list, idx + 1, len, selected);

			selected[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		int len = nums.length;

		Permutation(nums, answer, new ArrayList<>(), 0, nums.length, new boolean[len]);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
	}

}
