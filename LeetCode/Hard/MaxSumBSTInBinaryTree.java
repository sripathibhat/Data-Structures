// 1373
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
    public int maxSumBST(TreeNode root) {
        MinMax res = maxSum(root);
        return ans;
    }
    
    private MinMax maxSum(TreeNode root) {
        if (root == null) {
            return new MinMax();
        } 
        MinMax left = maxSum(root.left);
        MinMax right = maxSum(root.right);
        MinMax m = new MinMax();
        if (left.isBST == false || right.isBST == false || left.max > root.val || right.min <= root.val) {
            m.isBST = false;
            m.sum = Math.max(left.sum, right.sum);
            // ans = Math.max(ans, m.sum);
            return m;
        }
        m.isBST = true;
        m.sum = left.sum + right.sum + root.val;
        ans = Math.max(ans, m.sum);
        m.min = root.left != null ? left.min : root.val;
        m.max = root.right != null ? right.max : root.val;
        return m;
    }
    
    class MinMax {
        int min, max, sum;
        boolean isBST;
        
        MinMax() {
            min=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;
            sum=0;
            isBST=true;
        }
    }
}