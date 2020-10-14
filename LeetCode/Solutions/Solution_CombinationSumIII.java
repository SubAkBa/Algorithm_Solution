import java.util.*;

public class Solution_CombinationSumIII {

	public void DFS(List<List<Integer>> answer, List<Integer> list, int k, int start, int sum, int n) {
		if (k == 0) {
			if (sum == n)
				answer.add(new ArrayList<>(list));
			return;
		}

		if (sum >= n || start == 10)
			return;

		list.add(start);
		DFS(answer, list, k - 1, start + 1, sum + start, n);
		list.remove(list.size() - 1);
		DFS(answer, list, k, start + 1, sum, n);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> answer = new ArrayList<>();

		DFS(answer, new ArrayList<>(), k, 1, 0, n);

		return answer;
	}
}
