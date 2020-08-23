import java.util.*;

public class Solution_PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public void DFS(List<List<Integer>> answer, List<Integer> curnodes, TreeNode cur, int cursum, int sum) {
		if (cur == null)
			return;

		curnodes.add(cur.val);

		if (cur.left == null && cur.right == null && sum == (cursum + cur.val)) {
			answer.add(new LinkedList<>(curnodes));
			curnodes.remove(curnodes.size() - 1);
			return;
		}

		DFS(answer, curnodes, cur.left, cursum + cur.val, sum);
		DFS(answer, curnodes, cur.right, cursum + cur.val, sum);

		curnodes.remove(curnodes.size() - 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> answer = new ArrayList<>();

		DFS(answer, new ArrayList<>(), root, 0, sum);

		return answer;
	}
}
