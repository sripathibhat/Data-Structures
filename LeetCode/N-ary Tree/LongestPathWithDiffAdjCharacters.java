/**

You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered 
from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. 
Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.

 

Example 1:

Input: parent = [-1,0,0,1,1,2], s = "abacbe"
Output: 3
Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3. 
The length of this path is 3, so 3 is returned.
It can be proven that there is no longer path that satisfies the conditions. 


Example 2:

Input: parent = [-1,0,0,0], s = "aabc"
Output: 3
Explanation: The longest path where each two adjacent nodes have different characters is the path: 2 -> 0 -> 3. 
The length of this path is 3, so 3 is returned.

*/

class Solution {

    private int result = 0;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;

        // Build adjacency list
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }

        // DFS from root
        result = 0;
        dfs(0, children, s);
        return result;
    }

    // Returns longest chain going downward from this node
    private int dfs(int node, List<List<Integer>> children, String s) {
        int top1 = 0;
        int top2 = 0;

        for (int child : children.get(node)) {
            int childChain = dfs(child, children, s);

            // Only extend if adjacent characters differ
            if (s.charAt(child) != s.charAt(node)) {
                if (childChain > top1) {
                    top2 = top1;
                    top1 = childChain;
                } else if (childChain > top2) {
                    top2 = childChain;
                }
            }            
        }

        // Path through this node
        result = Math.max(result, top1 + top2 + 1);

        // Return longest single chain downward
        return top1 + 1;
    }
}

