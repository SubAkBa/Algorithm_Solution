import java.util.*;

public class Solution_길찾기게임 {

	public static void PostOrder(List<Integer> list, Node current) {
		if (current.left != null)
			PostOrder(list, current.left);

		if (current.right != null)
			PostOrder(list, current.right);

		list.add(current.idx);
	}

	public static void PreOrder(List<Integer> list, Node current) {
		list.add(current.idx);

		if (current.left != null)
			PreOrder(list, current.left);

		if (current.right != null)
			PreOrder(list, current.right);
	}

	public static void InsertNode(Node parent, Node child) {
		if (parent.x > child.x) {
			if (parent.left == null)
				parent.left = child;
			else
				InsertNode(parent.left, child);
		} else {
			if (parent.right == null)
				parent.right = child;
			else
				InsertNode(parent.right, child);
		}
	}

	public static int[][] solution(int[][] nodeinfo) {
		int nlen = nodeinfo.length;
		Node[] nodes = new Node[nlen];

		for (int i = 0; i < nlen; ++i)
			nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);

		Arrays.sort(nodes, (a, b) -> a.y == b.y ? Integer.compare(a.x, b.x) : Integer.compare(b.y, a.y));

		Node root = nodes[0];
		for (int i = 1; i < nlen; ++i)
			InsertNode(root, nodes[i]);

		List<Integer> preorder_list = new ArrayList<>();
		PreOrder(preorder_list, root);

		List<Integer> postorder_list = new ArrayList<>();
		PostOrder(postorder_list, root);

		int[][] answer = new int[2][nlen];
		for (int i = 0; i < nlen; ++i) {
			answer[0][i] = preorder_list.get(i);
			answer[1][i] = postorder_list.get(i);
		}

		return answer;
	}

	public static class Node {
		int x, y;
		int idx;
		Node left, right;

		public Node(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 },
				{ 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } })));
	}
}
