
public class Solution_LinkedListinBinaryTree {

	public boolean isValid(ListNode head, TreeNode root) {
		if (head == null)
			return true;

		if (root == null)
			return false;

		if (head.val == root.val)
			return isValid(head.next, root.left) || isValid(head.next, root.right);

		return false;
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		boolean result = isValid(head, root);

		if (!result && root != null)
			result |= isSubPath(head, root.left) || isSubPath(head, root.right);

		return result;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
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
