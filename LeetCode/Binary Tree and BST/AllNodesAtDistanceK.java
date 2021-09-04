/*
    Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a
    distance k from the target node.

    You can return the answer in any order.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        preorder(root, null, parentMap);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(target);
        visited.add(target.val);
        int level = 0;

        // BFS
        while(!q.isEmpty()) {
            if(level == k) {
                break;
            }

            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // Add parent of current node
                TreeNode parent = parentMap.get(node);
                if(parent != null && !visited.contains(parent.val)) {
                    q.add(parent);
                    visited.add(parent.val);
                }

                // Add left node of current node
                TreeNode left = node.left;
                if(left != null && !visited.contains(left.val)) {
                    q.add(left);
                    visited.add(left.val);
                }

                // Add right node of current node
                TreeNode right = node.right;
                if(right != null && !visited.contains(right.val)) {
                    q.add(right);
                    visited.add(right.val);
                }
            }
            level++;
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }
        return res;
    }
    
    private void preorder(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(node == null) {
            return;
        }
        parentMap.put(node, parent);
        preorder(node.left, node, parentMap);
        preorder(node.right, node, parentMap);
    }
}