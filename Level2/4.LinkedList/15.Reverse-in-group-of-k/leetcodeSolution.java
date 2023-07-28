public class leetcodeSolution {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
        
       class Solution {
           
           public int findLength(ListNode head){
               int len = 0;
               ListNode curr = head;
               
               while(curr != null){
                   len++;
                   curr = curr.next;
               }
               return len;
           }
           public ListNode reverseRec(ListNode head, int len, int k){
               if(head == null || len < k){
                   return head;
               }
               
               int temp = k;
               ListNode curr = head, prev = null, next = null;
               
               while(temp-- > 0){
                   next = curr.next;
                   curr.next = prev;
                   prev = curr;
                   curr = next;
               }
               
               ListNode rev = reverseRec(curr, len - k, k);
               head.next = rev;
               return prev;
           }
           public ListNode reverseKGroup(ListNode head, int k) {
               if(head == null || k == 1){
                   return head;
               }
               int len = findLength(head);
               return reverseRec(head, len, k);
           }
       }
}
