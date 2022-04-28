class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    // find length then return (length-k+1)th node
    int length(ListNode head) {
        if (head == null)
            return 0;

        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    ListNode xthNodeFromEnd1(ListNode head, int x) {
        int len = length(head);

        ListNode curr = head;
        for (int i = 1; i < len - x + 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // Take a pointer say front and make it point to the xth node from the start of
    // the list. Now move the front pointer and the head pointer one node at a time
    // until the front pointer reaches the last node. At this moment the head
    // pointer must be pointing to the xth node from the end of the list.
    ListNode xthNodeFromEnd(ListNode head, int x) {
        ListNode front = head;
        for (int i = 1; i < x; i++) {
            front = front.next;
        }
        if (front.next == null) {
            return head;
        }
        while (front.next != null) {
            front = front.next;
            head = head.next;
        }
        return head;
    }
}
