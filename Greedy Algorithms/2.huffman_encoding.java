import java.util.*;

class Solution {
    public class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
        }
    }
    public void traversal(Node root, ArrayList<String> result, String s){
        
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(s);
        }
        
        traversal(root.left, result, s + "0");
        traversal(root.right, result, s + "1");
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            if(a.data == b.data){
                return 1;
            }
            else{
                return a.data - b.data;
            }
        });
        
        for(int val : f){
            pq.add(new Node(val));
        }
        
        while(pq.size() > 1){
            Node left = pq.remove();
            Node right = pq.remove();
            
            Node root = new Node(left.data + right.data);
            root.left = left;
            root.right = right;
            
            pq.add(root);
        }
        
        ArrayList<String> result = new ArrayList<>();
        traversal(pq.remove(), result, "");
        
        return result;
    }
}