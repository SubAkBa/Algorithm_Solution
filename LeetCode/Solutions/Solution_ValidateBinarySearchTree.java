import java.util.*;

public class Solution_ValidateBinarySearchTree {

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

	public boolean DFS(TreeNode temp, long min, long max) {
		if (temp == null)
			return true;

		if (temp.val <= min || temp.val >= max)
			return false;

		return DFS(temp.left, min, temp.val) && DFS(temp.right, temp.val, max);
	}

	public boolean isValidBST(TreeNode root) {
		return DFS(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static void main(String[] args) {
	}

}
