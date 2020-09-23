import java.util.*;

public class Solution_SubsetsII {

	public static void DFS(List<List<Integer>> answer, List<Integer> list, int[] nums, int idx, int len) {
		answer.add(new ArrayList<>(list));
		System.out.println(answer);

		if (idx == len)
			return;

		for (int i = idx; i < len; ++i) {
			if (i > idx && nums[i - 1] == nums[i])
				continue;

			list.add(nums[i]);
			DFS(answer, list, nums, i + 1, len);
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();

		int len = nums.length;

		Arrays.sort(nums);
		DFS(answer, new ArrayList<>(), nums, 0, len);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
	}
}
