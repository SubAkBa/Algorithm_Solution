import java.util.*;

public class Solution_CopyListwithRandomPointer {

	public class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;

		HashMap<Node, Node> map = new HashMap<>();
		
		Node temp = head;
		while (temp != null) {
			map.put(temp, new Node(temp.val));
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			map.get(temp).next = map.get(temp.next);
			map.get(temp).random = map.get(temp.random);
		}

		return map.get(head);
	}
}
