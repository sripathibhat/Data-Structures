/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // visit all nodes and create duplicate nodes, put them to a hashtable
        // oldNode: newNode
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap();
        Set<Integer> visited = new HashSet();
        Queue<Node> q = new LinkedList();
        q.add(node);
        visited.add(node.val);
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node nd = q.poll();
                List<Node> ns = nd.neighbors;
                for (Node x: ns) {
                    if (!visited.contains(x.val)) {
                        visited.add(x.val);
                        q.add(x);
                        map.put(x, new Node(x.val));
                    }
                    map.get(nd).neighbors.add(map.get(x));
                }
            }
        }
        
        return map.get(node);
        
        // visited.clear();
        // Node temp = map.get(node);
        // q.add(node);
        // visited.add(node.val);
        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     for(int i=0; i<size; i++) {
        //         Node nd = q.poll();
        //         Node res = map.get(nd);
        //         List<Node> ns = nd.neighbors;
        //         for(Node x: ns) {
        //             if(!visited.contains(x.val)) {
        //                 visited.add(x.val);
        //                 q.add(x);
        //             }
        //             res.neighbors.add(map.get(x));
        //         }
        //     }
        // }
        // return temp;
    }
}
