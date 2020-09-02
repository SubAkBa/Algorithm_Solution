import java.io.*;

public class tree_1991_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int treecount = Integer.parseInt(br.readLine());

		char[] treedata = br.readLine().replaceAll(" ", "").toCharArray();

		Tree tree = new Tree(treedata[0], treedata[1], treedata[2]);

		for (int i = 1; i < treecount; i++) {
			treedata = br.readLine().replaceAll(" ", "").toCharArray();
			tree.Add(treedata[0], treedata[1], treedata[2]);
		}

		tree.PreOrder(tree.root);
		System.out.println();
		tree.InOrder(tree.root);
		System.out.println();
		tree.PostOrder(tree.root);

		br.close();
	}

}

class TreeNode {
	TreeNode leftnode, rightnode;
	private char data;

	public TreeNode(char data) {
		this.leftnode = null;
		this.rightnode = null;
		this.data = data;
	}

	public char getData() {
		return data;
	}
}



class Tree {
	TreeNode root;

	public Tree(char data, char left, char right) {
		root = new TreeNode(data);

		if (data != '.')
			root = new TreeNode(data);
		if (left != '.')
			root.leftnode = new TreeNode(left);
		if (right != '.')
			root.rightnode = new TreeNode(right);
	}

	public void Add(char data, char left, char right) {
		SearchNode(root.leftnode, data, left, right);
		SearchNode(root.rightnode, data, left, right);
	}

	public void SearchNode(TreeNode node, char data, char left, char right) {
		if (node == null)
			return;

		if (node.getData() == data) {
			if (left != '.')
				node.leftnode = new TreeNode(left);
			if (right != '.')
				node.rightnode = new TreeNode(right);
		} else {
			SearchNode(node.leftnode, data, left, right);
			SearchNode(node.rightnode, data, left, right);
		}
	}

	public void PreOrder(TreeNode root) {
		System.out.print(root.getData());
		if (root.leftnode != null)
			PreOrder(root.leftnode);
		if (root.rightnode != null)
			PreOrder(root.rightnode);
	}

	public void InOrder(TreeNode root) {
		if (root.leftnode != null)
			InOrder(root.leftnode);
		System.out.print(root.getData());
		if (root.rightnode != null)
			InOrder(root.rightnode);
	}

	public void PostOrder(TreeNode root) {
		if (root.leftnode != null)
			PostOrder(root.leftnode);
		if (root.rightnode != null)
			PostOrder(root.rightnode);
		System.out.print(root.getData());
	}
}