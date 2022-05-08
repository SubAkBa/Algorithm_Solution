
public class Solution_MergeTwoBinaryTrees {
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

    public TreeNode DFS(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;

        if (root2 == null)
            return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = DFS(root1.left, root2.left);
        root.right = DFS(root1.right, root2.right);

        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return DFS(root1, root2);
    }
}
