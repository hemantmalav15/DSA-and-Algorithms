public class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Find Mid Node
    public static ListNode midNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sp = head;
        ListNode fp = head.next;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }

    // Reverse the list
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // function that folds the list
    public static void fold(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = midNode(head);
        ListNode shead = mid.next;
        mid.next = null;
        shead = reverse(shead);

        ListNode c1 = head;
        ListNode c2 = shead;
        ListNode f1 = null;
        ListNode f2 = null;
        while (c1 != null && c2 != null) {
            // Backup
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

}
