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
    //Method 1
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null)return head;
        
        int n = len(head);
        if(n == k)return head;
        
        // Make linkedlist circular -> point lastNode.next to head 
        // and break the link of kth node and return (k+1)th Node
        Node tail = head;
        
        for(int i = 1; i<k; i++){
            tail = tail.next;
        }
        Node end = tail.next;
        
        Node temp = end;
        while(temp.next != null){
             temp = temp.next;
        }
        temp.next = head;
        tail.next = null;
        return end;
    }
}
