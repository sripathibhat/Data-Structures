// 1302
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
    public int deepestLeavesSum(TreeNode root) {
//         int h = getHeight(root);
//         int sum = 0;
//         Queue<LevelNode> q = new LinkedList();
//         q.add(new LevelNode(root, 1));
//         while(!q.isEmpty()) {
//             LevelNode ln = q.poll();
//             if(ln.level == h) {
//                 sum += ln.node.val;
//             }
            
//             if(ln.node.left != null) {
//                 q.add(new LevelNode(ln.node.left, ln.level+1));
//             }
            
//             if(ln.node.right != null) {
//                 q.add(new LevelNode(ln.node.right, ln.level+1));
//             }
//         }
//         return sum;
        
        int sum = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cn = q.poll();
                sum += cn.val;
                if(cn.left != null) {
                    q.add(cn.left);
                }
                if(cn.right != null) {
                    q.add(cn.right);
                }
            }
        }
        
        return sum;
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }
}

class LevelNode {
    TreeNode node;
    int level;
    
    LevelNode(TreeNode n, int l) {
        node = n;
        level = l;
    }
}