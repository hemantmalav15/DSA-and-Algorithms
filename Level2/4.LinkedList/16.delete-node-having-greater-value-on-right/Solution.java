class Node {
    int data;
    Node next;
 
   Node(int data) {
       this.data = data;
   }
 }

 //link -------> https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
 class Solution
 {
     Node reverse(Node node)
     {
         Node prev = null;
         Node current = node;
         Node next = null;
         while (current != null) {
             next = current.next;
             current.next = prev;
             prev = current;
             current = next;
         }
         node = prev;
         return node;
     }
     
     Node compute(Node head)
     {
         if(head == null || head.next == null){
             return head;
         }
         head = reverse(head);
         int max = head.data;
         
         Node curr = head;
         Node dummy = new Node(-1);
         
         Node prev = dummy;
         while(curr != null){
             if(curr.data >= max){
                 prev.next = curr;
                 prev = prev.next;
                 max = Math.max(max, curr.data);
             }
             curr = curr.next;
         }
         prev.next = null;
         return reverse(dummy.next);
     }
 }
   