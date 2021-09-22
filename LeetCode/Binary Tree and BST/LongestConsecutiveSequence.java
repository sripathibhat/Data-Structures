/*

    Given a binary tree, find the lenght of the longest consecutive sequence path.
    The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
    The longest consecutive path need to be from parent to child [cannot be the reverse].

*/

class Solution {
    public int longestConsecutive(TreeNode root) {
        int max[] = new int[1];
        solve(root, 0, 0, max);
        return max;
    }

    private void solve(TreeNode root, int cnt, int target, int max[]) {
        if(root == null) {
            return;
        }
        if(root.val == target) {
            cnt++;
        }
        else {
            cnt = 1;
        }
        max[0] = Math.max(max[0], cnt);
        solve(root.left, cnt, root.val + 1, max);
        solve(root.right, cnt, root.val + 1, max);
    }
}