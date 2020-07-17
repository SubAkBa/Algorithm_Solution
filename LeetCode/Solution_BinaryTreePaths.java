import java.util.*;

public class Solution_BinaryTreePaths {

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

	public void DFS(TreeNode temp, List<Integer> paths, List<String> answer) {
		if (temp == null)
			return;

		paths.add(temp.val);

		if (temp.left == null && temp.right == null) {
			StringBuilder sb = new StringBuilder();
			sb.append(paths.get(0));
			for (int i = 1; i < paths.size(); ++i)
				sb.append("->" + paths.get(i));

			answer.add(sb.toString());
			return;
		}

		if (temp.left != null) {
			DFS(temp.left, paths, answer);
			paths.remove(paths.size() - 1);
		}

		if (temp.right != null) {
			DFS(temp.right, paths, answer);
			paths.remove(paths.size() - 1);
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<>();

		DFS(root, new ArrayList<>(), answer);

		return answer;
	}

	public static void main(String[] args) {
	}

}
