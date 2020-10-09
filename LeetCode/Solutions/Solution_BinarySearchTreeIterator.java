import java.util.*;

public class Solution_BinarySearchTreeIterator {
	class BSTIterator {
		Queue<Integer> queue;

		public BSTIterator(TreeNode root) {
			queue = new LinkedList<>();

			if (root != null)
				PushInQ(root);
		}

		/** @return the next smallest number */
		public int next() {
			return queue.poll();
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		public void PushInQ(TreeNode node) {
			if (node.left != null)
				PushInQ(node.left);

			queue.offer(node.val);

			if (node.right != null)
				PushInQ(node.right);
		}
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
