
public class Solution_KthSmallestElementinaBST {
	static int count = 0, answer = 0;

	public static void DFS(TreeNode temp, int k) {
		if (answer != 0)
			return;

		if (temp.left != null)
			DFS(temp.left, k);

		++count;

		if (count == k) {
			answer = temp.val;
			return;
		}

		if (temp.right != null)
			DFS(temp.right, k);
	}

	public static int kthSmallest(TreeNode root, int k) {
		DFS(root, k);

		return 0;
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

	public static void main(String[] args) {
	}

}
