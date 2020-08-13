import java.util.*;

public class Solution_CombinationSum {

	public static void Combination(List<List<Integer>> answer, List<Integer> list, int[] candidates, int len,
			int target, int curSum, int idx) {

		if (curSum == target) {
			answer.add(new ArrayList<>(list));
			return;
		}

		for (int i = idx; i < len; ++i) {
			if (curSum + candidates[i] > target)
				continue;

			list.add(candidates[i]);
			Combination(answer, list, candidates, len, target, curSum + candidates[i], i);
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<>();

		Combination(answer, new ArrayList<>(), candidates, candidates.length, target, 0, 0);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
	}
}
