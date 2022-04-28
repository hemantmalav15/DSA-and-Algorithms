public class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sp = head;
        ListNode fp = head;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }

    public static ListNode mergeTwoSortedLinkedlist(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }

        ListNode c1 = l1;
        ListNode c2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = (c1 == null) ? c2 : c1;

        return dummy.next;
    }

    public static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = midleNode(head);
        ListNode newHead = mid.next;
        mid.next = null;

        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(newHead);
        return mergeTwoSortedLinkedlist(l1, l2);
    }

}