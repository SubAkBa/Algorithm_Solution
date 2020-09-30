
public class Solution_SearchinaBinarySearchTree {
	static TreeNode answer;

	public void DFS(TreeNode node, int val) {
		if (answer != null || node == null)
			return;

		if (node.val == val) {
			answer = node;
			return;
		}

		DFS(node.left, val);
		DFS(node.right, val);
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;

		answer = null;
		DFS(root, val);

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
