class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Approach 1 -> O(n^2)
    int sum(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;

        int lSum = sum(root.left);
        int rSum = sum(root.right);

        return lSum + rSum + root.data;
    }

    boolean isSumTree(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean left = isSumTree(root.left);
        boolean right = isSumTree(root.right);

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return left && right && (leftSum + rightSum == root.data);
    }

    //Approach 2 -> O(n)
    //Fastest method
    static class pair{
        int sum;
        boolean bool;
        
        pair(boolean bool, int sum){
            this.bool = bool;
            this.sum = sum;
        }
    }
    //this function would work in O(n) time bcoz it visits all the nodes atonce
    pair isSumTreeFast(Node root){
        if(root == null){
	        return new pair(true,0);
	    }
	    
	    if(root.left == null && root.right == null){
	        return new pair(true,root.data);
	    }
        pair left = isSumTreeFast(root.left);
        pair right = isSumTreeFast(root.right);
        
        int leftSum =  left.sum; // sum(root.left);
        int rightSum = right.sum;// sum(root.right);
        
        boolean leftAns = left.bool;
        boolean rightAns = right.bool;
        
        boolean ans = leftAns && rightAns && (leftSum + rightSum == root.data);
        pair p = new pair(ans, leftSum + rightSum + root.data);
        return p;
    }
	boolean isSumTreef(Node root)
	{
	    return isSumTreeFast(root).bool;
	}
}
