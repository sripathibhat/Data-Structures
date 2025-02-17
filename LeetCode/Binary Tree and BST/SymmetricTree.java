/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false

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
    public boolean isSymmetric(TreeNode root) {
        TreeNode mirror = mirrorTree(root);
        if (mirrorsMatch(root, mirror)) {
            return true;
        }
        return false;
    }
    
    private TreeNode mirrorTree(TreeNode root) {
        TreeNode temp;
        if (root != null) {
            mirrorTree(root.left);
            mirrorTree(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp; 
        }
        return root;
    }
    
    private boolean mirrorsMatch(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        return (mirrorsMatch(r1.left, r2.right) && mirrorsMatch(r1.right, r2.left));
    }
    
}
