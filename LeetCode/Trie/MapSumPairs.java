class MapSum {

    /** Initialize your data structure here. */
    TrieNode root;
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for(char ch: key.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.wt = val;
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return dfs(node);
    }
    
    private class TrieNode {
        TrieNode children[];
        int wt;
        TrieNode() {
            wt = 0;
            children = new TrieNode[26];
        }
    }
    
    private int dfs(TrieNode node) {
        int total = 0;
        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) {
                total += dfs(node.children[i]);
            }
        }
        return total + node.wt;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */