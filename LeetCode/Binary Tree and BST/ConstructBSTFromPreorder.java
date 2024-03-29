/*

    Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree
    and return its root.

    It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

    A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any
    descendant of Node.right has a value strictly greater than Node.val.

    A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        // return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
        return solve(0, preorder.length - 1, preorder);
    }
    
    private TreeNode solve(int start, int end, int[] pre) {
        if(start > end) {
            return null;
        }
        TreeNode node = new TreeNode(pre[start]);
        int rightIndex = -1;
        for(int i = start + 1; i <= end; i++) {
            if(pre[i] > pre[start]) {
                rightIndex = i;
                break;
            }
        }
  
        if(rightIndex != -1) {
            node.left = solve(start + 1, rightIndex - 1, pre);
            node.right = solve(rightIndex, end, pre);
        } else {
            node.left = solve(start + 1, end, pre);
        }
        return node;
    }

    int index = 0;
    private TreeNode helper(int start, int end, int pre[]) {
        if(index >= pre.length || pre[index] < start || pre[index] > end) {
            return null;
        }
        int val = pre[index];
        TreeNode node = new TreeNode(val);
        index++;
        node.left = helper(start, val - 1, pre);
        node.right = helper(val + 1, end, pre);
        return node;
    }
}