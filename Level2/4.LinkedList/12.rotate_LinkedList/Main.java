class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

class Solution{
    public int len (Node head){
        if(head == null)return 0;
        
        int count = 0;
        Node curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    //function to reverse the list
    public static Node reverse(Node head){
        if(head == null || head.next == null)return head;
        
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null)return head;
        
        int n = len(head);
        if(n == k)return head;
        
        // we are using reversal algorithm here
        Node front = head;
        Node tail = head;
        
        for(int i = 1; i<k; i++){
            tail = tail.next;
        }
        Node end = tail.next;
        tail.next = null;
        end = reverse(end);
        front = reverse(front);
        
        head.next = end;
        return reverse(front);
    }
}
