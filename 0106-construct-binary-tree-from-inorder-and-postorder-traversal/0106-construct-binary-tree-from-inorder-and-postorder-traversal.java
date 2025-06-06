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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        TreeNode root = build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(postStart > postEnd || inStart > inEnd) 
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsOnRight = inEnd - inRoot;
        root.left = build(postorder, postStart, postEnd - 1 - numsOnRight, inorder, inStart, inRoot - 1, inMap);
        root.right = build(postorder, postEnd - numsOnRight, postEnd - 1, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}