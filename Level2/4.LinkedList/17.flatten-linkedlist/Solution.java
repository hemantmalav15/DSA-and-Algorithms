class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node merge(Node h1, Node h2){
        if(h1 == null || h2 == null){
            return (h1 == null) ? h2 : h1;
        }
        Node c1 = h1;
        Node c2 = h2;
        
        Node dummy = new Node(-1);
        Node prev = dummy;
        
        while(c1 != null && c2 != null){
            if(c1.data <= c2.data){
                prev.bottom = c1;
                c1 = c1.bottom;
            }
            else{
                prev.bottom = c2;
                c2 = c2.bottom;
            }
            prev = prev.bottom;
        }
        prev.bottom = (c1 == null) ? c2 : c1;
        return dummy.bottom;
    }
    Node flatten(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }
        //simply get the next node from linkedlist
        Node next = root.next;
        root.next = null;
        
        //then flat the rest of the list 
        Node rest = flatten(next);
        //then simply merger both but remember we have to merge on bottom not next pointer
        return merge(root, rest);
    }
}