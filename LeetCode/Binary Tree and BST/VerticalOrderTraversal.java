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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 1));
        Map<Integer, List<Node>> map = new TreeMap<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                if(node.node.left != null) {
                    q.add(new Node(node.node.left, node.hd - 1, node.level + 1));
                }
                if(node.node.right != null) {
                    q.add(new Node(node.node.right, node.hd + 1, node.level + 1));
                }
                List<Node> list = map.getOrDefault(node.hd, new ArrayList<>());
                list.add(node);
                map.put(node.hd, list);
            }
        }
        
        for(Map.Entry<Integer, List<Node>> entry: map.entrySet()) {
            List<Node> nodes = entry.getValue();
            Collections.sort(nodes, (a, b) -> a.level == b.level ? a.node.val - b.node.val : a.level - b.level);
            List<Integer> l = new ArrayList<>();
            for(Node node: nodes) {
                l.add(node.node.val);
            }
            res.add(l);
        }
        return res;
    }
    
    class Node {
        TreeNode node;
        int hd;
        int level;
        Node(TreeNode n, int h, int l) {
            node = n;
            hd = h;
            level = l;
        }
    }
}