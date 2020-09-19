import java.util.*;

public class Solution_Subsets {

	public static void Combination(List<List<Integer>> answer, int[] nums, int idx, int len, List<Integer> list) {
		if (idx == len)
			return;

		list.add(nums[idx]);
		Combination(answer, nums, idx + 1, len, list);

		answer.add(new ArrayList<>(list));

		list.remove(list.size() - 1);
		Combination(answer, nums, idx + 1, len, list);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		int len = nums.length;

		answer.add(new ArrayList<>());
		Combination(answer, nums, 0, len, new ArrayList<>());

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
	}
}
