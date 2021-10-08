/*

    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a
    dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

    Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

*/

class Trie {
    
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char ch: word.toCharArray()) {
            if(temp.getChild(ch - 'a') == null) {
                temp.setChild(ch - 'a', new TrieNode());
            }
            temp = temp.getChild(ch - 'a');
        }
        temp.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(char ch: word.toCharArray()) {
            if(temp.getChild(ch - 'a') == null) {
                return false;
            }
            temp = temp.getChild(ch - 'a');
        }
        return temp.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char ch: prefix.toCharArray()) {
            if(temp.getChild(ch - 'a')  == null) {
                return false;
            }
            temp = temp.getChild(ch - 'a') ;
        }
        return true;
    }

}

class TrieNode {
    private boolean endOfWord;
    private TrieNode children[];

    public TrieNode() {
        endOfWord = false;
        children = new TrieNode[26];
    }
    
    public boolean isEndOfWord() {
        return endOfWord;
    }
    
    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
    
    public TrieNode getChild(int index) {
        return children[index];
    }
    
    public void setChild(int index, TrieNode child) {
        children[index] = child;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */