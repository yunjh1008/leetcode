// 100. Same Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(q == null || p == null) return false;
        if(p.val != q.val) return false;
        
        return true;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Iteration
        if(p == null && q == null) return true;
        if(!check(p, q)) return false;
        
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        stackP.push(p);
        stackQ.push(q);
        
        while(!stackP.isEmpty()) {
            TreeNode currentP = stackP.pop();
            TreeNode currentQ = stackQ.pop();
            
            if(!check(currentP, currentQ)) return false;
            
            if(!check(currentP.left, currentQ.left)) return false;
            if(currentP.left != null) {
                stackP.push(currentP.left);
                stackQ.push(currentQ.left);
            }

            if(!check(currentP.right, currentQ.right)) return false;
            if(currentP.right != null) {
                stackP.push(currentP.right);
                stackQ.push(currentQ.right);
            }
        }
        
        return true;
        
        // Recursive
//         if(p == null && q == null) return true;
//         if(p == null || q == null) return false;
//         if(p.val != q.val) return false;
        
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
