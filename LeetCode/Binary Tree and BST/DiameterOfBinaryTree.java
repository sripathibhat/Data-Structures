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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return ans - 1;
    }
    
    private int solve(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = solve(node.left);
        int right = solve(node.right);
        int temp = Math.max(left, right) + 1;
        ans = Math.max(ans, Math.max(temp, 1 + left + right));
        return temp;
    }
}