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
    public boolean isSameTree(TreeNode p, TreeNode q) {  
        // TC and SC -> O(min(P, Q))
        if(p == null && q == null) return true;
        if(p == null || q == null) return false; // then lesser num of nodes in either one of 'em
        if(p.val == q.val) 
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}