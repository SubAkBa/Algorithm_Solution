import java.util.*;

public class Solution_MergekSortedLists {

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

	public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        
        if (len == 0)
            return null;
        
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

		for (int i = 0; i < len; ++i) {
			while (lists[i] != null) {
				pq.offer(lists[i]);
				lists[i] = lists[i].next;
			}
		}

		ListNode start = new ListNode();
		ListNode answer = start;
        
		while (!pq.isEmpty()) {
			start.next = new ListNode(pq.poll().val);
			start = start.next;
		}

		return answer.next;
	}
}
