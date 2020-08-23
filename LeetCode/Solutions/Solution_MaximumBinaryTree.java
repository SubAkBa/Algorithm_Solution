
public class Solution_MaximumBinaryTree {

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

	public int MaxFunc(int[] nums, int left, int right) {
		int idx = left;
		for (int i = left + 1; i < right; ++i) {
			if (nums[idx] < nums[i])
				idx = i;
		}

		return idx;
	}

	public TreeNode DFS(int[] nums, int left, int right) {
		if (left == right)
			return null;

		int idx = MaxFunc(nums, left, right);

		TreeNode current = new TreeNode(nums[idx]);
		current.left = DFS(nums, left, idx);
		current.right = DFS(nums, idx + 1, right);

		return current;
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		int len = nums.length;

		return DFS(nums, 0, len);
	}
}
