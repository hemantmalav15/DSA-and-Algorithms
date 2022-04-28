class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Tree {
    // Approach 1 -> O(n^2)
    int height(Node root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        int ans = Math.max(lh, rh) + 1;
        return ans;
    }
    // Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root) {
        if (root == null)
            return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        int lh = height(root.left);
        int rh = height(root.right);
        int ans = Math.abs(lh - rh);

        return (left && right && ans <= 1);
    }

    //Approach 2 -> O(n)
    //Better approach
    static class pair{
        boolean bool;
        int h;
        
        pair(boolean bool, int h){
            this.bool = bool;
            this.h = h;
        }
    }
    pair isBalancedFast(Node root)
    {
      if(root == null){
          return new pair(true,0);
      }
      
	  pair left = isBalancedFast(root.left);
	  pair right = isBalancedFast(root.right);
	  
	  boolean leftAns = left.bool;
	  boolean rightAns = right.bool;
	  
	  int lh =  left.h;  //height(root.left);
	  int rh =  right.h; //height(root.right);
	  
	  boolean diff = Math.abs(lh - rh) <= 1;
	  boolean ans = leftAns && rightAns && diff;
	  
	  int height = Math.max(left.h,right.h) + 1;
	  pair p = new pair(ans,height);
	  return p;
 
    }
    //Function to check whether a binary tree is balanced or not.
    boolean isBalancedF(Node root)
    {
	    return isBalancedFast(root).bool;
    }
}
