import java.util.*;

public class Solution_CombinationSumII {

	public static void Combination(List<List<Integer>> answer, List<Integer> list, int[] candidates, int target,
			int curSum, int idx, int len) {
		if (curSum == target) {
			answer.add(new ArrayList<>(list));
			return;
		}

		for (int i = idx; i < len; ++i) {
			if ((i > idx && candidates[i] == candidates[i - 1]) || curSum + candidates[i] > target)
				continue;

			list.add(candidates[i]);
			Combination(answer, list, candidates, target, curSum + candidates[i], i + 1, len);
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<>();
		int len = candidates.length;

		Arrays.sort(candidates);
		Combination(answer, new ArrayList<>(), candidates, target, 0, 0, len);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

}
