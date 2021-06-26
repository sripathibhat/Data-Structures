// 124
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        maxSum(root);
        return max;
    }
    
    int maxSum(TreeNode root) {
        if(root == null) return 0;
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        int temp = Math.max(root.val, root.val + Math.max(left, right));
        max = Math.max(max, Math.max(temp, root.val + left + right));
        return temp;
    }
}