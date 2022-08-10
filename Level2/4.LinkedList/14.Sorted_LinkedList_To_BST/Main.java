//Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}

class Solution
{
    class pair{
        LNode mid;
        LNode prev;
        
        public pair(LNode mid , LNode prev){
            this.mid = mid;
            this.prev = prev;
        }
    }
    //This method finds the middle node
    public pair mid(LNode head){
        if(head == null || head.next == null)return new pair(head,null);
        LNode sp = head;
        LNode fp = head;
        
        LNode prev = null;
        while(fp != null && fp.next != null){
            prev = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        return new pair(sp,prev);
    }
    //Convert linkedlist to BST
    public TNode sortedListToBST(LNode head)
    {
        if(head == null)return null;
        if(head.next == null){
            return new TNode(head.data);
        }
        // It returns the pair of (mid,prevOfMid);
        pair midNode = mid(head);
        // break the links between mid and mid's prev
        midNode.prev.next = null;
        LNode newHead = midNode.mid.next;
        // break the links between mid and mid's next
        midNode.mid.next = null;
        
        //Create a new Node treeNode
        TNode root = new TNode(midNode.mid.data);
        
        //recursively make BST 
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(newHead);
        return root;
    }
}