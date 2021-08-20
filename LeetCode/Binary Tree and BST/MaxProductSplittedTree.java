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
    long max = 0;
    long sum = 0;
    public int maxProduct(TreeNode root) {
        postorder(root);
        solve(root);
        return (int) (max % 1000000007);
    }
    
    private void postorder(TreeNode root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        sum += root.val;
    }
    
    private long solve(TreeNode root) {
        if(root == null) {
            return 0;
        }
        long l = solve(root.left);
        long r = solve(root.right);
        long localSum = l + r + root.val;
        max = Math.max(max, localSum * (sum - localSum));
        return localSum;
    }
}