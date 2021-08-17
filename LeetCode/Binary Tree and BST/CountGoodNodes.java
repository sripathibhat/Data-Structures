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
    public int goodNodes(TreeNode root) {
        return goodCount(root, Integer.MIN_VALUE);
    }
    
    private int goodCount(TreeNode root, int maxSeenSoFar) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.val >= maxSeenSoFar) {
            count++;
        }
        count += goodCount(root.left, Math.max(root.val, maxSeenSoFar));
        count += goodCount(root.right, Math.max(root.val, maxSeenSoFar));
        return count;
    }
}