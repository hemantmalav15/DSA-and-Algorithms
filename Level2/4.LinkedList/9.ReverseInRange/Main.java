public class Main {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {

            // Back up
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseInRange(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        if (m == n) {
            return head;
        }

        ListNode end = head;
        ListNode temp = head;
        for (int i = 1; i < n && temp.next != null; i++) {
            temp = temp.next;
        }
        end = temp.next;
        temp.next = null;

        temp = head;
        ListNode prev = head;
        for (int i = 1; i < m && temp.next != null; i++) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != head) {
            prev.next = null;
        }
        ListNode rev = reverse(temp);
        if (temp == head) {
            ListNode t = rev;
            while (t.next != null) {
                t = t.next;
            }
            t.next = end;
            return rev;
        } else {
            prev.next = rev;
            ListNode t = rev;
            while (t.next != null) {
                t = t.next;
            }
            t.next = end;
        }

        return head;
    }

}
