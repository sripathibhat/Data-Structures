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
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // inorder
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if(root != null) {
            if(!inorder(root.left)) {
                return false;
            }
            if(root.val <= prev) {
                return false;
            }
            prev = (long) root.val;
            return inorder(root.right);
        }
        return true;
    }
}