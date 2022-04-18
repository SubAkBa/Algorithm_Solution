public class Solution_RemoveDuplicatesfromSortedListII {

    public static class ListNode {
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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevHead = new ListNode(0, head);
        ListNode cur = prevHead;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                cur.next = head.next;
            } else {
                cur = cur.next;
            }

            head = head.next;
        }

        return prevHead.next;
    }
}
