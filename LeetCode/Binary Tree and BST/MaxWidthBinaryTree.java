/**

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:

Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).

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
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> leftPositions = new HashMap<>();
        return solve(root, 0, 0, leftPositions, 0);
    }

    private int solve(TreeNode node, int depth, int position, Map<Integer, Integer> leftPositions, int maxWidth) {
        if (node == null) {
            return maxWidth;
        }
        if (!leftPositions.containsKey(depth)) {
            leftPositions.put(depth, position);
        }
        maxWidth = Math.max(maxWidth, position - leftPositions.get(depth) + 1);
        int left = solve(node.left, depth + 1, position * 2, leftPositions, maxWidth);
        int right = solve(node.right, depth + 1, position * 2 + 1, leftPositions, maxWidth);
        return Math.max(left, right);
    }
}
