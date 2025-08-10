/**

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

Example 1:

Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.


Example 2:

Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.

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
    private Map<Integer, List<Integer>> graph;

    public int amountOfTime(TreeNode root, int start) {
        graph = new HashMap<>();
        
        // Convert tree to undirected graph
        convertToGraph(root);
        
        // Use BFS to find maximum distance from start node
        return findMaxDistance(start);
    }

    private void convertToGraph(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // Create adjacency list entry for current node
        graph.putIfAbsent(node.val, new ArrayList<>());
        
        // Connect left child
        if (node.left != null) {
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.val).add(node.left.val);
            graph.get(node.left.val).add(node.val);
        }
        
        // Connect right child
        if (node.right != null) {
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.val).add(node.right.val);
            graph.get(node.right.val).add(node.val);
        }
        
        // Recursively process children
        convertToGraph(node.left);
        convertToGraph(node.right);
    }
    
    private int findMaxDistance(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int minutes = -1;
        
        // Add start node
        queue.offer(start);
        visited.add(start);
        
        // BFS to find maximum distance
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            
            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // Process all neighbors
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        } 
        return minutes;
    }
}
