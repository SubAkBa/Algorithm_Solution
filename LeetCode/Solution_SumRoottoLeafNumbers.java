
public class Solution_SumRoottoLeafNumbers {
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

	int answer = 0;

	public void DFS(TreeNode temp, int value) {
		if (temp.left == null && temp.right == null) {
			answer += value;
			return;
		}

		if (temp.left != null)
			DFS(temp.left, value * 10 + temp.left.val);

		if (temp.right != null)
			DFS(temp.right, value * 10 + temp.right.val);
	}

	public int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		
		DFS(root, root.val);

		return answer;
	}
}
