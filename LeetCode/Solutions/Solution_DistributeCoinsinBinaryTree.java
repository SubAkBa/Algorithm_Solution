
public class Solution_DistributeCoinsinBinaryTree {

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
	
	static int step;

	public int DFS(TreeNode current) {
		if (current == null)
			return 0;

		int coins = DFS(current.left) + DFS(current.right);

		coins += current.val - 1;
		
		step += Math.abs(coins);

		return coins;
	}

	public int distributeCoins(TreeNode root) {
		step = 0;
		
		DFS(root);
		
		return step;
	}
}
