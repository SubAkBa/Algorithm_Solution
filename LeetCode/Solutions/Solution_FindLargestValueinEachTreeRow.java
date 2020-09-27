import java.util.*;

public class Solution_FindLargestValueinEachTreeRow {

	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> answer = new ArrayList<>();

		if (root == null)
			return answer;

		queue.add(root);

		while (!queue.isEmpty()) {
			int depth = queue.size();
			int max_value = Integer.MIN_VALUE;

			while ((--depth) >= 0) {
				TreeNode cur = queue.poll();

				max_value = Math.max(max_value, cur.val);

				if (cur.left != null)
					queue.offer(cur.left);

				if (cur.right != null)
					queue.offer(cur.right);
			}

			answer.add(max_value);
		}

		return answer;
	}

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
}
