/*
    Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n.
    Return the answer in any order.
*/

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


// Reference - Coding decoded
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
    
    private List<TreeNode> solve(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
        }
        else if(start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);
        }
        else {
            for(int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = solve(start, i - 1);
                List<TreeNode> rightTrees = solve(i + 1, end);
                for(TreeNode left: leftTrees) {
                    for(TreeNode right: rightTrees) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        list.add(node);
                    }
                }
            }
        }
        return list;
    }
}