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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    private void solve(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if(root == null ) {
            return;
        }
        list.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }

        solve(root.left, sum - root.val, list, res);
        solve(root.right, sum - root.val, list, res);
        list.remove(list.size() - 1);
        return;
    }
}