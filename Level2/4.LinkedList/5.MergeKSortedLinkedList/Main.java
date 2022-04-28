import java.util.PriorityQueue;

public class Main {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode curr = null;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (pq.size() > 0) {

            curr = pq.remove();
            prev.next = curr;
            prev = prev.next;
            curr = curr.next;

            if (curr != null) {
                pq.add(curr);
            }
        }
        return dummy.next;
    }

}
