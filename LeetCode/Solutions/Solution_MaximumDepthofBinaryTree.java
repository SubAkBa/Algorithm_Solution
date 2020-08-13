
public class Solution_MaximumDepthofBinaryTree {

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

	public int DFS(TreeNode temp, int depth) {
		if (temp == null)
			return depth;

		return Math.max(DFS(temp.left, depth + 1), DFS(temp.right, depth + 1));
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return DFS(root, 0);
	}

	public static void main(String[] args) {
	}

}
