import java.util.*;

public class Solution_AddTwoNumbers {

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

	public void DFS(ListNode l1, ListNode l2, int plus, ListNode answer) {
		int sum1 = 0, sum2 = 0;

		if (l1 != null) {
			sum1 = l1.val;
			l1 = l1.next;
		}

		if (l2 != null) {
			sum2 = l2.val;
			l2 = l2.next;
		}

		int calc = (sum1 + sum2 + plus);
		answer.val = calc % 10;

		if (l1 == null && l2 == null) {

			if (calc >= 10)
				answer.next = new ListNode(1);
			return;
		}
		
		answer.next = new ListNode();

		DFS(l1, l2, calc / 10, answer.next);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = new ListNode();

		DFS(l1, l2, 0, answer);

		return answer;
	}
}
