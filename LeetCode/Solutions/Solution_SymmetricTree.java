
public class Solution_SymmetricTree {

	public boolean DFS(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		return (n1.val == n2.val) && DFS(n1.left, n2.right) && DFS(n1.right, n2.left);

	}

	public boolean isSymmetric(TreeNode root) {
		return DFS(root, root);
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
