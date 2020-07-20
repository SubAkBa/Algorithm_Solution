
public class Solution_IntersectionofTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode curA = headA, curB = headB;
		ListNode EndA = null, EndB = null;

		while (curA != curB) {
			if (EndA != null && EndB != null && EndA != EndB)
				return null;

			if (curA.next == null) {
				EndA = curA;
				curA = headB;
			} else
				curA = curA.next;

			if (curB.next == null) {
				EndB = curB;
				curB = headA;
			} else
				curB = curB.next;
		}

		return curA;
	}
}
