
public class Solution_RangeSumofBST {

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;

		int sum = 0;

		if (L <= root.val && root.val <= R)
			sum += root.val;

		sum += rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

		return sum;
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
