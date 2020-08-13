
public class Solution_SameTree {
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

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		if ((p == null && q != null) || (p != null && q == null) || p.val != q.val)
			return false;

		if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
			return true;

		return false;
	}

	public static void main(String[] args) {
	}

}
