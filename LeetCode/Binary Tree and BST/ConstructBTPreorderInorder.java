/*

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        int cnt = 0;
        for (int i: inorder) {
            map.put(i, cnt++);
        }
        TreeNode root = solve(0, 0, inorder.length - 1, preorder, map);
        return root;
    }
    
    private TreeNode solve(int preS, int inS, int inE, int preorder[], Map<Integer, Integer> map) {
        if (preS > preorder.length - 1 || inS > inE) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preS]);
        int inIndex = map.get(node.val);
        node.left = solve(preS + 1, inS, inIndex - 1, preorder, map);
        node.right = solve(preS + inIndex - inS + 1, inIndex + 1, inE, preorder, map);
        return node;
    }
}
