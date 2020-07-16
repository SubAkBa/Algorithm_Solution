import java.util.*;

public class Solution_MinimumDepthofBinaryTree {
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

	public int minDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int depth = 1;

		if (root == null)
			return 0;

		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			while ((--size) >= 0) {
				TreeNode from = queue.poll();

				if (from.left == null && from.right == null)
					return depth;

				if (from.left != null)
					queue.offer(from.left);

				if (from.right != null)
					queue.offer(from.right);
			}

			++depth;
		}

		return depth;
	}

	public static void main(String[] args) {
	}

}
