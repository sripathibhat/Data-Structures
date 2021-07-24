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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList();
        if(root == null) {
            return l;
        }
        TreeNode cn;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size-1; i++) {
                cn = q.poll();
                if(cn.left != null) {
                    q.add(cn.left);
                }
                if(cn.right != null) {
                    q.add(cn.right);
                }
            }
            cn = q.poll();
            if(cn.left != null) {
                q.add(cn.left);
            }
            if(cn.right != null) {
                q.add(cn.right);
            }
            l.add(cn.val);
        }
        return l;
    }
}