
public class Solution_InvertBinaryTree {

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

	public void DFS(TreeNode current, TreeNode answer) {
		if (current == null)
			return;

		if (current.right != null) {
			answer.left = new TreeNode(current.right.val);
			DFS(current.right, answer.left);
		}

		if (current.left != null) {
			answer.right = new TreeNode(current.left.val);
			DFS(current.left, answer.right);
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode answer = new TreeNode(root.val);

		DFS(root, answer);

		return answer;
	}
}
