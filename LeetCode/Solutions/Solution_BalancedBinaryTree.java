
public class Solution_BalancedBinaryTree {

	public int DFS(TreeNode node) {
		if (node == null)
			return 0;

		int lheight = DFS(node.left);
		int rheight = DFS(node.right);

		if (lheight == -1 || rheight == -1 || Math.abs(lheight - rheight) > 1)
			return -1;

		return Math.max(lheight, rheight) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		return DFS(root) != -1;
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
