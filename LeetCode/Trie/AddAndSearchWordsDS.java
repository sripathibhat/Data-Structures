class WordDictionary {
    
    private class TrieNode {
        TrieNode child[] = new TrieNode[26];
        boolean isWord;
    }

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        char a[] = word.toCharArray();
        for(int i=0; i<a.length; i++) {
            if(temp.child[a[i]-'a'] == null) {
                temp.child[a[i]-'a'] = new TrieNode();
            }
            temp = temp.child[a[i]-'a'];
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(root, 0, word.toCharArray());
    }
    
    private boolean helper(TrieNode node, int index, char a[]) {
        for(int i=index; i<a.length; i++) {
            if(a[i] == '.') {
                for(int j=0; j<26; j++) {
                    if(node.child[j] != null) {
                        if(helper(node.child[j], i+1, a)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else {
                if(node.child[a[i]-'a'] == null) {
                   return false;
                }
                node = node.child[a[i]-'a'];
            }
        }
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */