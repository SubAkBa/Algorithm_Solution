import java.util.*;

public class Solution_IntersectionofTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // O(N+M) / O(N)
    public static ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
        Set<ListNode> table = new HashSet<>();

        while (headA != null) {
            table.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (table.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    // O(N+M) / O(1)
    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode cpA = headA, cpB = headB;

        while (cpA != cpB) {
            cpA = cpA == null ? headB : cpA.next;
            cpB = cpB == null ? headA : cpB.next;
        }

        return cpA;
    }
}
