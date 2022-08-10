public class Main {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh, rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int ld = diameterOfBinaryTree(root.left); // left diameter
        int rd = diameterOfBinaryTree(root.right);// right diameter
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh + rh , Math.max(ld,rd));
    }
}
