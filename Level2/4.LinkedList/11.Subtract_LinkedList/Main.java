import java.util.*;
class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Reverse function
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = head;

        while (curr != null) {

            // backUp
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Length function
    public static int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len += 1;
        }
        return len;
    }

    // This function subtract two LinkedList
    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            l2.val = -l2.val;
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // if length of l1 is smaller swap it with l2 bcoz we will solve this on the
        // base that l1 is always greater than l2
        int length1 = length(l1);
        int length2 = length(l2);

        if (length1 < length2) {
            ListNode save = l2;
            l2 = l1;
            l1 = save;
        }
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);

        // int len1 = length(l1);
        // int len2 = length(l2);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        int borrow = 0, diff = 0;
        while (c1 != null) {

            diff = borrow;
            diff += c1.val;
            c1 = c1.next;

            if (c2 != null) {
                diff -= c2.val;
                c2 = c2.next;
            }

            if (diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }

            prev.next = new ListNode(diff);
            prev = prev.next;
        }
        ListNode curr = reverse(dummy.next);
        while (curr != null) {
            if (curr.val == 0) {
                curr = curr.next;
            } else {
                return curr;
            }
        }
        // if we come here that means list contains all the zero(both numbers was same)
        // so we have to return a node with zero value
        return new ListNode(0);
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }

}