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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<QueueEntry> q = new LinkedList();
        if(root==null) {
            return res;
        }
        q.add(new QueueEntry(root, 0));
        while(!q.isEmpty()) {
            List<Integer> sl = new ArrayList();
            int size = q.size();
            boolean even = false;
            for(int i=0; i<size; i++) {
                QueueEntry temp = q.poll();
                sl.add(temp.node.val);
                even = temp.level % 2 == 0;
                if(temp.node.left!=null) {
                    q.add(new QueueEntry(temp.node.left, temp.level+1));
                }
                if(temp.node.right!=null) {
                    q.add(new QueueEntry(temp.node.right, temp.level+1));
                }         
                
            }
            if(even) {
                res.add(sl);
            } else {
                Collections.reverse(sl);
                res.add(sl);
            }
        }
        return res;
    }
    
}

class QueueEntry {
    TreeNode node;
    int level;
    
    QueueEntry(TreeNode n, int l) {
        node = n;
        level = l;
    }
}