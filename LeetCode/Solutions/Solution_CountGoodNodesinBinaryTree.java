
public class Solution_CountGoodNodesinBinaryTree {

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

    static int count;

    public void DFS(TreeNode node, int maxValue) {
        if (node.val >= maxValue)
            ++count;

        if (node.left != null)
            DFS(node.left, Math.max(node.left.val, maxValue));

        if (node.right != null)
            DFS(node.right, Math.max(node.right.val, maxValue));
    }

    public int goodNodes(TreeNode root) {
        count = 0;

        DFS(root, root.val);

        return count;
    }
}
