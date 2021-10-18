/*

    Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true
    if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

    Two nodes of a binary tree are cousins if they have the same depth with different parents.

    Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        Node n1 = findDepthAndParent(root, null, x, 0); // find parent and depth of x
        Node n2 = findDepthAndParent(root, null, y, 0); // find parent and depth of y
        return n1.parent != n2.parent && n1.depth == n2.depth;
    }
    
    private Node findDepthAndParent(TreeNode root, TreeNode parent, int val, int depth) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return new Node(parent, depth);
        }
        Node node = findDepthAndParent(root.left, root, val, depth + 1);
        if(node == null) {
            return findDepthAndParent(root.right, root, val, depth + 1);
        }
        return node;
    }
    
    class Node {
        TreeNode parent;
        int depth;
        Node(TreeNode p, int d) {
            parent = p;
            depth = d;
        }
    }
}