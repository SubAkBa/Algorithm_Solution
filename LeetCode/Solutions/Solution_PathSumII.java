import java.util.*;

public class Solution_PathSumII {
	static List<List<Integer>> answer;

	public static void DFS(TreeNode cur, int sum, LinkedList<Integer> curnodes, int cursum) {
		if (cur == null)
			return;

		curnodes.add(new Integer(cur.val));

		if (cur.left == null && cur.right == null && sum == cursum) {
			answer.add(new LinkedList<>(curnodes));
			curnodes.removeLast();
			return;
		}

		DFS(cur.left, sum, curnodes, cursum + cur.val);
		DFS(cur.right, sum, curnodes, cursum + cur.val);

		curnodes.removeLast();
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		answer = new ArrayList<>();

		DFS(root, sum, new LinkedList<>(), 0);

		return answer;
	}

	public class TreeNode {
		int val;
		TreeNode left, right;

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

	public static void main(String[] args) {
	}

}
