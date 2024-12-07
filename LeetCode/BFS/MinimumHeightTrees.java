/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        
        int ind[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge: edges) {
            ind[edge[0]]++;
            ind[edge[1]]++;
            map.putIfAbsent(edge[0], new ArrayList());
            map.putIfAbsent(edge[1], new ArrayList());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                n--;
                for (int adj: map.get(poll)) {
                    if (--ind[adj] == 1) {
                        queue.add(adj);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList(queue);
        return list;
    }
}
