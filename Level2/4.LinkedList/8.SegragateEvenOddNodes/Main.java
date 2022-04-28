public class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = new ListNode(-1); // dummy node for even
        ListNode etail = even; // tail of even

        ListNode odd = new ListNode(-1); // dummy node for odd
        ListNode otail = odd; // tail of odd

        ListNode curr = head;
        while (curr != null) {
            // Even value
            if (curr.val % 2 == 0) {
                etail.next = curr;
                etail = etail.next;
            }
            // odd value
            else {
                otail.next = curr;
                otail = otail.next;
            }
            curr = curr.next;
        }

        otail.next = null;
        etail.next = odd.next;
        return even.next;
    }

}
